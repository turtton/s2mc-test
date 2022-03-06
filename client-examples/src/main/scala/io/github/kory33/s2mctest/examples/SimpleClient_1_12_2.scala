package io.github.kory33.s2mctest.examples

import cats.Monad
import cats.effect.IO
import com.comcast.ip4s.SocketAddress
import io.github.kory33.s2mctest.core.client.api.worldview.{PositionAndOrientation, WorldTime}
import io.github.kory33.s2mctest.core.client.{PacketAbstraction, ProtocolPacketAbstraction}
import io.github.kory33.s2mctest.core.clientpool.{AccountPool, ClientPool}
import io.github.kory33.s2mctest.impl.client.abstraction.{
  DisconnectAbstraction,
  KeepAliveAbstraction,
  PlayerPositionAbstraction,
  TimeUpdateAbstraction
}
import io.github.kory33.s2mctest.impl.clientpool.ClientInitializationImpl
import io.github.kory33.s2mctest.impl.connection.packets.PacketDataPrimitives.{
  LenPrefixedSeq,
  UByte,
  VarInt
}
import io.github.kory33.s2mctest.impl.connection.packets.PacketDataCompoundTypes.Slot
import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Play.ClientBound.{
  ChunkData_withBlockEntity,
  DeclareRecipes,
  EntityHeadLook,
  EntityMove_i16,
  EntityTeleport_f64,
  EntityVelocity,
  JoinGame_WorldNames_IsHard,
  TeleportPlayer_WithDismount,
  UpdateLight_WithTrust
}
import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Play.ServerBound.ClickWindow_State
import monocle.Lens
import monocle.macros.GenLens

@main
def simpleClient_1_12_2(): Unit = {
  import io.github.kory33.s2mctest.impl.connection.protocol.versions
  import versions.v1_17_1.{protocolVersion, loginProtocol, playProtocol}
  import cats.implicits.given
  import cats.effect.unsafe.implicits.global

  case class WorldView(position: PositionAndOrientation, worldTime: WorldTime)
  object WorldView {
    val unitLens: Lens[WorldView, Unit] = Lens[WorldView, Unit](_ => ())(_ => s => s)
    val worldTimeLens: Lens[WorldView, WorldTime] = GenLens[WorldView](_.worldTime)
//    val positionLens: Lens[WorldView, PositionAndOrientation] = GenLens[WorldView](_.position)
  }

  val address = SocketAddress.fromString("localhost:25565").get

  val packetAbstraction = ProtocolPacketAbstraction
    .empty[IO, WorldView](playProtocol)
    .thenAbstractWithLens(KeepAliveAbstraction.forProtocol, WorldView.unitLens)
    .thenAbstractWithLens(TimeUpdateAbstraction.forProtocol, WorldView.worldTimeLens)

  val accountPool = AccountPool.default[IO].unsafeRunSync()
  val clientPool = ClientPool
    .withInitData(
      accountPool,
      WorldView(PositionAndOrientation.zero, WorldTime.zero),
      ClientInitializationImpl(
        address,
        protocolVersion,
        loginProtocol,
        playProtocol,
        packetAbstraction
      )
    )
    .cached(50)
    .unsafeRunSync()

  val program: IO[Unit] =
    clientPool.recycledClient.use { client =>
      client.readLoopUntilDefined[Nothing] {
        case client.ReadLoopStepResult.WorldUpdate(worldView) =>
          IO(println(s"WorldView updated: $worldView")) >> IO.pure(None)

        // CAUTION: Receiving a parameter `packet` here *SIGNIFICANTLY* (about 6s to 60s) increases
        // compilation time. You may wish to ignore the parameter with
        // `PacketArrived(_)` to reduce compilation time.
        case client.ReadLoopStepResult.PacketArrived(packet) => packet match {
            case _: EntityVelocity | _: EntityMove_i16 | _: EntityHeadLook | _: EntityTeleport_f64 | _: JoinGame_WorldNames_IsHard | _: ChunkData_withBlockEntity | _: UpdateLight_WithTrust | _: DeclareRecipes =>
              IO.none
            case _: TeleportPlayer_WithDismount => IO(println("seeeeeeeeeeeeeend!!!!!!!!!!!!!!")) >> client.writePacket(ClickWindow_State[Slot.Upto_1_17_1](
              UByte(0),
              VarInt(0),
              0,
              0,
              VarInt(0),
              LenPrefixedSeq(Vector()),
              Slot.Upto_1_17_1(false, None, None, None)
            )) >> IO.pure(None)
            case _ => IO(println(s"Visible packet: $packet")) >> IO.pure(None)
          }
      }
    }

  program.unsafeRunSync()
}
