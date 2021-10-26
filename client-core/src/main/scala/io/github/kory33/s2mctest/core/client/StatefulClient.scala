package io.github.kory33.s2mctest.core.client

import cats.effect.Ref
import cats.{Monad, MonadThrow}
import io.github.kory33.s2mctest.core.connection.codec.interpreters.ParseResult
import io.github.kory33.s2mctest.core.connection.transport.ProtocolBasedTransport

/**
 * The class of stateful Minecraft clients.
 *
 * This client makes a distinction between hidden "internal" packets and "visible" packets
 * within [[SelfBoundPackets]]. Internal packets are packets that are abstracted away by
 * [[abstraction]], and cannot be observed by the user of this class. Visible packets are those
 * that are not filtered by the [[abstraction]].
 */
// format: off
class StatefulClient[
  F[_]: MonadThrow,
  SelfBoundPackets <: Tuple,
  PeerBoundPackets <: Tuple,
  State
](
  val transport: ProtocolBasedTransport[F, SelfBoundPackets, PeerBoundPackets],
  stateRef: Ref[F, State],
  abstraction: PacketAbstraction[Tuple.Union[SelfBoundPackets], State, F[List[transport.Response]]]
) {
  // format: on

  import cats.implicits.given

  /**
   * Read the next packet, either internal or visible, and return the result.
   *
   * If we have read an internal packet, the client state is updated by the abstraction
   * function, then a [[None]] is returned. Otherwise the client state will remain unchanged and
   * the read visible packet will be returned in a [[Some]].
   *
   * As a consequence, the returned `Tuple.Union[SelfBoundPackets]` will not contain packets
   * abstracted away by the `abstraction`.
   */
  val nextPacketOrStateUpdate: F[Option[Tuple.Union[SelfBoundPackets]]] =
    for {
      result <- transport.nextPacket
      packet <- result match {
        case ParseResult.Just(packet) => Monad[F].pure(packet)
        case ParseResult.WithExcessBytes(packet, excess, _) =>
          MonadThrow[F].raiseError {
            java
              .io
              .IOException(
                s"Excess bytes while reading packets: parsed $packet but with excess $excess"
              )
          }
        case ParseResult.Errored(error, input) =>
          MonadThrow[F].raiseError {
            java.io.IOException(s"Error while reading packets: got $error on $input")
          }
      }
      updateFunction = abstraction.stateUpdate(packet)
      _ <- updateFunction.traverse { f =>
        for {
          additionalAction <- stateRef.modify(f)
          responses <- additionalAction
          _ <- responses.traverse(transport.write)
        } yield ()
      }
    } yield if updateFunction.isEmpty then Some(packet) else None

  /**
   * Read the current client state.
   */
  val getState: F[State] = stateRef.get

  /**
   * Keep reading packets from the transport, until we see a visible packet, and return. By
   * definition, the returned `Tuple.Union[SelfBoundPackets]` will not contain packets
   * abstracted away by the `abstraction`.
   */
  val nextPacket: F[Tuple.Union[SelfBoundPackets]] =
    Monad[F].untilDefinedM(nextPacketOrStateUpdate)

  /**
   * Write a [[packet]] to the underlying transport.
   */
  def writePacket[P: transport.protocolView.peerBound.CanEncode](packet: P): F[Unit] =
    transport.writePacket(packet)

}

object StatefulClient {

  // format: off
  def withInitialState[F[_]: Ref.Make: MonadThrow, SelfBoundPackets <: Tuple, PeerBoundPackets <: Tuple, State](
    transport: ProtocolBasedTransport[F, SelfBoundPackets, PeerBoundPackets],
    initialState: State,
    abstraction: PacketAbstraction[Tuple.Union[SelfBoundPackets], State, F[List[transport.Response]]]
    // format: on
  ): F[StatefulClient[F, SelfBoundPackets, PeerBoundPackets, State]] =
    Monad[F].map(Ref.of[F, State](initialState)) { ref =>
      new StatefulClient(transport, ref, abstraction)
    }

}