package io.github.kory33.s2mctest.impl.connection.protocol

import io.github.kory33.s2mctest.core.connection.codec.{ByteCodec, ByteEncode}
import io.github.kory33.s2mctest.impl.connection.packets.PacketDataCompoundTypes.{
  Position,
  SculkVibrationSignalDestination,
  Slot
}
import shapeless3.deriving.K0

/**
 * The object that will hold codecs for PacketIntent datatypes.
 *
 * Version-specific protocols can import all given members of this object to gain access to
 * given instances of [[ByteCodec]] without constructing codec instances (hence saves some
 * compilation time).
 */
class PacketIntentCodecCache(using ByteCodec[Position]) {
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Handshaking.ClientBound.*
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Handshaking.ServerBound.*
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Login.ClientBound.*
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Login.ServerBound.*
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Play.ClientBound.*
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Play.ServerBound.*
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Status.ClientBound.*
  import io.github.kory33.s2mctest.impl.connection.packets.PacketIntent.Status.ServerBound.*
  import io.github.kory33.s2mctest.impl.connection.codec.ByteCodecs.Common.given
  import io.github.kory33.s2mctest.impl.connection.codec.ByteCodecs.autogenerateFor
  import io.github.kory33.s2mctest.impl.connection.codec.decode.macros.GenByteDecode
  import io.github.kory33.s2mctest.impl.connection.codec.decode.macros.GenByteDecode.given
  
  // format: off
  given ByteCodec[Handshake] = autogenerateFor[Handshake]
  given ByteCodec[TeleportConfirm] = autogenerateFor[TeleportConfirm]
  given ByteCodec[QueryBlockNBT] = autogenerateFor[QueryBlockNBT]
  given ByteCodec[SetDifficulty] = autogenerateFor[SetDifficulty]
  given ByteCodec[TabComplete] = autogenerateFor[TabComplete]
  given ByteCodec[TabComplete_NoAssume] = autogenerateFor[TabComplete_NoAssume]
  given ByteCodec[TabComplete_NoAssume_NoTarget] = autogenerateFor[TabComplete_NoAssume_NoTarget]
  given ByteCodec[ChatMessage] = autogenerateFor[ChatMessage]
  given ByteCodec[ClientStatus] = autogenerateFor[ClientStatus]
  given ByteCodec[ClientStatus_u8] = autogenerateFor[ClientStatus_u8]
  given ByteCodec[ClientSettings] = autogenerateFor[ClientSettings]
  given ByteCodec[ClientSettings_u8] = autogenerateFor[ClientSettings_u8]
  given ByteCodec[ClientSettings_u8_Handsfree] = autogenerateFor[ClientSettings_u8_Handsfree]
  given ByteCodec[ClientSettings_u8_Handsfree_Difficulty] = autogenerateFor[ClientSettings_u8_Handsfree_Difficulty]
  given ByteCodec[ConfirmTransactionServerbound] = autogenerateFor[ConfirmTransactionServerbound]
  given ByteCodec[EnchantItem] = autogenerateFor[EnchantItem]
  given ByteCodec[ClickWindowButton] = autogenerateFor[ClickWindowButton]
  given ByteCodec[ClickWindow_u8] = autogenerateFor[ClickWindow_u8]
  given ByteCodec[CloseWindow] = autogenerateFor[CloseWindow]
  given ByteCodec[PluginMessageServerbound] = autogenerateFor[PluginMessageServerbound]
  given ByteCodec[PluginMessageServerbound_i16] = autogenerateFor[PluginMessageServerbound_i16]
  given ByteCodec[EditBook] = autogenerateFor[EditBook]
  given ByteCodec[QueryEntityNBT] = autogenerateFor[QueryEntityNBT]
  given ByteCodec[UseEntity_Sneakflag] = autogenerateFor[UseEntity_Sneakflag]
  given ByteCodec[UseEntity_Hand] = autogenerateFor[UseEntity_Hand]
  given ByteCodec[UseEntity_Handsfree] = autogenerateFor[UseEntity_Handsfree]
  given ByteCodec[UseEntity_Handsfree_i32] = autogenerateFor[UseEntity_Handsfree_i32]
  given ByteCodec[GenerateStructure] = autogenerateFor[GenerateStructure]
  given ByteCodec[KeepAliveServerbound_i64] = autogenerateFor[KeepAliveServerbound_i64]
  given ByteCodec[KeepAliveServerbound_VarInt] = autogenerateFor[KeepAliveServerbound_VarInt]
  given ByteCodec[KeepAliveServerbound_i32] = autogenerateFor[KeepAliveServerbound_i32]
  given ByteCodec[LockDifficulty] = autogenerateFor[LockDifficulty]
  given ByteCodec[PlayerPosition] = autogenerateFor[PlayerPosition]
  given ByteCodec[PlayerPosition_HeadY] = autogenerateFor[PlayerPosition_HeadY]
  given ByteCodec[PlayerPositionLook] = autogenerateFor[PlayerPositionLook]
  given ByteCodec[PlayerPositionLook_HeadY] = autogenerateFor[PlayerPositionLook_HeadY]
  given ByteCodec[PlayerLook] = autogenerateFor[PlayerLook]
  given ByteCodec[Player] = autogenerateFor[Player]
  given ByteCodec[VehicleMove] = autogenerateFor[VehicleMove]
  given ByteCodec[SteerBoat] = autogenerateFor[SteerBoat]
  given ByteCodec[PickItem] = autogenerateFor[PickItem]
  given ByteCodec[CraftRecipeRequest] = autogenerateFor[CraftRecipeRequest]
  given ByteCodec[ClientAbilities_f32] = autogenerateFor[ClientAbilities_f32]
  given ByteCodec[ClientAbilities_u8] = autogenerateFor[ClientAbilities_u8]
  given ByteCodec[PlayerDigging] = autogenerateFor[PlayerDigging]
  given ByteCodec[PlayerDigging_u8] = autogenerateFor[PlayerDigging_u8]
  given ByteCodec[PlayerDigging_u8_u8y] = autogenerateFor[PlayerDigging_u8_u8y]
  given ByteCodec[PlayerAction] = autogenerateFor[PlayerAction]
  given ByteCodec[PlayerAction_i32] = autogenerateFor[PlayerAction_i32]
  given ByteCodec[SteerVehicle] = autogenerateFor[SteerVehicle]
  given ByteCodec[SteerVehicle_jump_unmount] = autogenerateFor[SteerVehicle_jump_unmount]
  given ByteCodec[CraftingBookData] = autogenerateFor[CraftingBookData]
  given ByteCodec[Pong] = autogenerateFor[Pong]
  given ByteCodec[SetDisplayedRecipe] = autogenerateFor[SetDisplayedRecipe]
  given ByteCodec[SetRecipeBookState] = autogenerateFor[SetRecipeBookState]
  given ByteCodec[NameItem] = autogenerateFor[NameItem]
  given ByteCodec[ResourcePackStatus] = autogenerateFor[ResourcePackStatus]
  given ByteCodec[ResourcePackStatus_hash] = autogenerateFor[ResourcePackStatus_hash]
  given ByteCodec[AdvancementTab] = autogenerateFor[AdvancementTab]
  given ByteCodec[SelectTrade] = autogenerateFor[SelectTrade]
  given ByteCodec[SetBeaconEffect] = autogenerateFor[SetBeaconEffect]
  given ByteCodec[HeldItemChange] = autogenerateFor[HeldItemChange]
  given ByteCodec[UpdateCommandBlock] = autogenerateFor[UpdateCommandBlock]
  given ByteCodec[UpdateCommandBlockMinecart] = autogenerateFor[UpdateCommandBlockMinecart]
  given ByteCodec[UpdateJigsawBlock_Joint] = autogenerateFor[UpdateJigsawBlock_Joint]
  given ByteCodec[UpdateJigsawBlock_Type] = autogenerateFor[UpdateJigsawBlock_Type]
  given ByteCodec[UpdateStructureBlock] = autogenerateFor[UpdateStructureBlock]
  given ByteCodec[SetSign] = autogenerateFor[SetSign]
  given ByteCodec[SetSign_i16y] = autogenerateFor[SetSign_i16y]
  given ByteCodec[ArmSwing] = autogenerateFor[ArmSwing]
  given ByteCodec[ArmSwing_Handsfree] = autogenerateFor[ArmSwing_Handsfree]
  given ByteCodec[ArmSwing_Handsfree_ID] = autogenerateFor[ArmSwing_Handsfree_ID]
  given ByteCodec[SpectateTeleport] = autogenerateFor[SpectateTeleport]
  given ByteCodec[PlayerBlockPlacement_f32] = autogenerateFor[PlayerBlockPlacement_f32]
  given ByteCodec[PlayerBlockPlacement_u8] = autogenerateFor[PlayerBlockPlacement_u8]
  given ByteCodec[PlayerBlockPlacement_u8_Item] = autogenerateFor[PlayerBlockPlacement_u8_Item]
  given ByteCodec[PlayerBlockPlacement_u8_Item_u8y] = autogenerateFor[PlayerBlockPlacement_u8_Item_u8y]
  given ByteCodec[PlayerBlockPlacement_insideblock] = autogenerateFor[PlayerBlockPlacement_insideblock]
  given ByteCodec[UseItem] = autogenerateFor[UseItem]
  given ByteCodec[SpawnObject] = autogenerateFor[SpawnObject]
  given ByteCodec[SpawnObject_i32] = autogenerateFor[SpawnObject_i32]
  given ByteCodec[SpawnObject_i32_NoUUID] = autogenerateFor[SpawnObject_i32_NoUUID]
  given ByteCodec[SpawnObject_VarInt] = autogenerateFor[SpawnObject_VarInt]
  given ByteCodec[SpawnExperienceOrb] = autogenerateFor[SpawnExperienceOrb]
  given ByteCodec[SpawnExperienceOrb_i32] = autogenerateFor[SpawnExperienceOrb_i32]
  given ByteCodec[SpawnGlobalEntity] = autogenerateFor[SpawnGlobalEntity]
  given ByteCodec[SpawnGlobalEntity_i32] = autogenerateFor[SpawnGlobalEntity_i32]
  given ByteCodec[SpawnMob_NoMeta] = autogenerateFor[SpawnMob_NoMeta]
  given ByteCodec[SpawnMob_WithMeta] = autogenerateFor[SpawnMob_WithMeta]
  given ByteCodec[SpawnMob_u8] = autogenerateFor[SpawnMob_u8]
  given ByteCodec[SpawnMob_u8_i32] = autogenerateFor[SpawnMob_u8_i32]
  given ByteCodec[SpawnMob_u8_i32_NoUUID] = autogenerateFor[SpawnMob_u8_i32_NoUUID]
  given ByteCodec[SpawnPainting_VarInt] = autogenerateFor[SpawnPainting_VarInt]
  given ByteCodec[SpawnPainting_String] = autogenerateFor[SpawnPainting_String]
  given ByteCodec[SpawnPainting_NoUUID] = autogenerateFor[SpawnPainting_NoUUID]
  given ByteCodec[SpawnPainting_NoUUID_i32] = autogenerateFor[SpawnPainting_NoUUID_i32]
  given ByteCodec[SpawnPlayer_f64_NoMeta] = autogenerateFor[SpawnPlayer_f64_NoMeta]
  given ByteCodec[SpawnPlayer_f64] = autogenerateFor[SpawnPlayer_f64]
  given ByteCodec[SpawnPlayer_i32] = autogenerateFor[SpawnPlayer_i32]
  given ByteCodec[SpawnPlayer_i32_HeldItem] = autogenerateFor[SpawnPlayer_i32_HeldItem]
  given ByteCodec[SpawnPlayer_i32_HeldItem_String] = autogenerateFor[SpawnPlayer_i32_HeldItem_String]
  given ByteCodec[Animation] = autogenerateFor[Animation]
  given ByteCodec[Statistics] = autogenerateFor[Statistics]
  given ByteCodec[BlockBreakAnimation] = autogenerateFor[BlockBreakAnimation]
  given ByteCodec[BlockBreakAnimation_i32] = autogenerateFor[BlockBreakAnimation_i32]
  given ByteCodec[UpdateBlockEntity] = autogenerateFor[UpdateBlockEntity]
  given ByteCodec[UpdateBlockEntity_Data] = autogenerateFor[UpdateBlockEntity_Data]
  given ByteCodec[BlockAction] = autogenerateFor[BlockAction]
  given ByteCodec[BlockAction_u16] = autogenerateFor[BlockAction_u16]
  given ByteCodec[BlockChange_VarInt] = autogenerateFor[BlockChange_VarInt]
  given ByteCodec[BlockChange_u8] = autogenerateFor[BlockChange_u8]
  given ByteCodec[BossBar] = autogenerateFor[BossBar]
  given ByteCodec[ServerDifficulty] = autogenerateFor[ServerDifficulty]
  given ByteCodec[ServerDifficulty_Locked] = autogenerateFor[ServerDifficulty_Locked]
  given ByteCodec[TabCompleteReply] = autogenerateFor[TabCompleteReply]
  given ByteCodec[DeclareCommands] = autogenerateFor[DeclareCommands]
  given ByteCodec[ServerMessage_Sender] = autogenerateFor[ServerMessage_Sender]
  given ByteCodec[ServerMessage_Position] = autogenerateFor[ServerMessage_Position]
  given ByteCodec[ServerMessage_NoPosition] = autogenerateFor[ServerMessage_NoPosition]
  given ByteCodec[MultiBlockChange_Packed] = autogenerateFor[MultiBlockChange_Packed]
  given ByteCodec[MultiBlockChange_VarInt] = autogenerateFor[MultiBlockChange_VarInt]
  given ByteCodec[MultiBlockChange_u16] = autogenerateFor[MultiBlockChange_u16]
  given ByteCodec[ConfirmTransaction] = autogenerateFor[ConfirmTransaction]
  given ByteCodec[WindowClose] = autogenerateFor[WindowClose]
  given ByteCodec[WindowOpen] = autogenerateFor[WindowOpen]
  given ByteCodec[WindowOpenHorse] = autogenerateFor[WindowOpenHorse]
  given ByteCodec[WindowOpen_u8] = autogenerateFor[WindowOpen_u8]
  given ByteCodec[WindowOpen_VarInt] = autogenerateFor[WindowOpen_VarInt]
  given ByteCodec[WindowProperty] = autogenerateFor[WindowProperty]
  given ByteCodec[SetCooldown] = autogenerateFor[SetCooldown]
  given ByteCodec[PluginMessageClientbound] = autogenerateFor[PluginMessageClientbound]
  given ByteCodec[PluginMessageClientbound_i16] = autogenerateFor[PluginMessageClientbound_i16]
  given ByteCodec[NamedSoundEffect] = autogenerateFor[NamedSoundEffect]
  given ByteCodec[NamedSoundEffect_u8] = autogenerateFor[NamedSoundEffect_u8]
  given ByteCodec[NamedSoundEffect_u8_NoCategory] = autogenerateFor[NamedSoundEffect_u8_NoCategory]
  given ByteCodec[Disconnect] = autogenerateFor[Disconnect]
  given ByteCodec[EntityAction] = autogenerateFor[EntityAction]
  given ByteCodec[Explosion] = autogenerateFor[Explosion]
  given ByteCodec[ChunkUnload] = autogenerateFor[ChunkUnload]
  given ByteCodec[SetCompression] = autogenerateFor[SetCompression]
  given ByteCodec[ChangeGameState] = autogenerateFor[ChangeGameState]
  given ByteCodec[KeepAliveClientbound_i64] = autogenerateFor[KeepAliveClientbound_i64]
  given ByteCodec[KeepAliveClientbound_VarInt] = autogenerateFor[KeepAliveClientbound_VarInt]
  given ByteCodec[KeepAliveClientbound_i32] = autogenerateFor[KeepAliveClientbound_i32]
  given ByteCodec[ChunkData_Biomes3D_VarInt] = autogenerateFor[ChunkData_Biomes3D_VarInt]
  given ByteCodec[ChunkData_Biomes3D_bool] = autogenerateFor[ChunkData_Biomes3D_bool]
  given ByteCodec[ChunkData_Biomes3D] = autogenerateFor[ChunkData_Biomes3D]
  given ByteCodec[ChunkData_HeightMap] = autogenerateFor[ChunkData_HeightMap]
  given ByteCodec[ChunkData] = autogenerateFor[ChunkData]
  given ByteCodec[ChunkData_NoEntities] = autogenerateFor[ChunkData_NoEntities]
  given ByteCodec[ChunkData_NoEntities_u16] = autogenerateFor[ChunkData_NoEntities_u16]
  given ByteCodec[ChunkData_17] = autogenerateFor[ChunkData_17]
  given ByteCodec[ChunkData_withBlockEntity] = autogenerateFor[ChunkData_withBlockEntity]
  given ByteCodec[ChunkDataBulk] = autogenerateFor[ChunkDataBulk]
  given ByteCodec[ChunkDataBulk_17] = autogenerateFor[ChunkDataBulk_17]
  given ByteCodec[Effect] = autogenerateFor[Effect]
  given ByteCodec[Effect_u8y] = autogenerateFor[Effect_u8y]

  /**
   * NOTE: Some compiler error relating to https://github.com/lampepfl/dotty/issues/13406
   * prevents us from calling `autogenerateFor` method with these three types.
   *
   * This seems to happen only with a type with more than 15 fields in which at
   * least one Option field is present.
   */
  given ByteCodec[Particle_f64] = ByteCodec(GenByteDecode.gen[Particle_f64], ByteEncode.forADT[Particle_f64])
  given ByteCodec[Particle_Data] = ByteCodec(GenByteDecode.gen[Particle_Data], ByteEncode.forADT[Particle_Data])
  given ByteCodec[Particle_Data13] = ByteCodec(GenByteDecode.gen[Particle_Data13], ByteEncode.forADT[Particle_Data13])

  given ByteCodec[Particle_VarIntArray] = autogenerateFor[Particle_VarIntArray]
  given ByteCodec[Particle_Named] = autogenerateFor[Particle_Named]
  given ByteCodec[JoinGame_WorldNames_IsHard] = autogenerateFor[JoinGame_WorldNames_IsHard]
  given ByteCodec[JoinGame_WorldNames] = autogenerateFor[JoinGame_WorldNames]
  given ByteCodec[JoinGame_HashedSeed_Respawn] = autogenerateFor[JoinGame_HashedSeed_Respawn]
  given ByteCodec[JoinGame_i32_ViewDistance] = autogenerateFor[JoinGame_i32_ViewDistance]
  given ByteCodec[JoinGame_i32] = autogenerateFor[JoinGame_i32]
  given ByteCodec[JoinGame_i8] = autogenerateFor[JoinGame_i8]
  given ByteCodec[JoinGame_i8_NoDebug] = autogenerateFor[JoinGame_i8_NoDebug]
  given ByteCodec[Maps] = autogenerateFor[Maps]
  given ByteCodec[Maps_NoLocked] = autogenerateFor[Maps_NoLocked]
  given ByteCodec[Maps_NoTracking] = autogenerateFor[Maps_NoTracking]
  given ByteCodec[Maps_NoTracking_Data] = autogenerateFor[Maps_NoTracking_Data]
  given ByteCodec[EntityMove_i16] = autogenerateFor[EntityMove_i16]
  given ByteCodec[EntityMove_i8] = autogenerateFor[EntityMove_i8]
  given ByteCodec[EntityMove_i8_i32_NoGround] = autogenerateFor[EntityMove_i8_i32_NoGround]
  given ByteCodec[EntityLookAndMove_i16] = autogenerateFor[EntityLookAndMove_i16]
  given ByteCodec[EntityLookAndMove_i8] = autogenerateFor[EntityLookAndMove_i8]
  given ByteCodec[EntityLookAndMove_i8_i32_NoGround] = autogenerateFor[EntityLookAndMove_i8_i32_NoGround]
  given ByteCodec[EntityLook_VarInt] = autogenerateFor[EntityLook_VarInt]
  given ByteCodec[EntityLook_i32_NoGround] = autogenerateFor[EntityLook_i32_NoGround]
  given ByteCodec[Entity] = autogenerateFor[Entity]
  given ByteCodec[Entity_i32] = autogenerateFor[Entity_i32]
  given ByteCodec[EntityUpdateNBT] = autogenerateFor[EntityUpdateNBT]
  given ByteCodec[VehicleTeleport] = autogenerateFor[VehicleTeleport]
  given ByteCodec[OpenBook] = autogenerateFor[OpenBook]
  given ByteCodec[SignEditorOpen] = autogenerateFor[SignEditorOpen]
  given ByteCodec[SignEditorOpen_i32] = autogenerateFor[SignEditorOpen_i32]
  given ByteCodec[Ping] = autogenerateFor[Ping]
  given ByteCodec[CraftRecipeResponse] = autogenerateFor[CraftRecipeResponse]
  given ByteCodec[PlayerAbilities] = autogenerateFor[PlayerAbilities]
  given ByteCodec[CombatEvent] = autogenerateFor[CombatEvent]
  given ByteCodec[EndCombatEvent] = autogenerateFor[EndCombatEvent]
  given ByteCodec[EnterCombatEvent] = autogenerateFor[EnterCombatEvent]
  given ByteCodec[DeathCombatEvent] = autogenerateFor[DeathCombatEvent]
  given ByteCodec[PlayerInfo] = autogenerateFor[PlayerInfo]
  given ByteCodec[PlayerInfo_String] = autogenerateFor[PlayerInfo_String]
  given ByteCodec[FacePlayer] = autogenerateFor[FacePlayer]
  given ByteCodec[TeleportPlayer_WithConfirm] = autogenerateFor[TeleportPlayer_WithConfirm]
  given ByteCodec[TeleportPlayer_WithDismount] = autogenerateFor[TeleportPlayer_WithDismount]
  given ByteCodec[TeleportPlayer_NoConfirm] = autogenerateFor[TeleportPlayer_NoConfirm]
  given ByteCodec[TeleportPlayer_OnGround] = autogenerateFor[TeleportPlayer_OnGround]
  given ByteCodec[EntityUsedBed] = autogenerateFor[EntityUsedBed]
  given ByteCodec[EntityUsedBed_i32] = autogenerateFor[EntityUsedBed_i32]
  given ByteCodec[UnlockRecipes_NoSmelting] = autogenerateFor[UnlockRecipes_NoSmelting]
  given ByteCodec[UnlockRecipes_WithSmelting] = autogenerateFor[UnlockRecipes_WithSmelting]
  given ByteCodec[UnlockRecipes_WithBlastSmoker] = autogenerateFor[UnlockRecipes_WithBlastSmoker]
  given ByteCodec[EntityDestroy] = autogenerateFor[EntityDestroy]
  given ByteCodec[EntityDestroy_u8] = autogenerateFor[EntityDestroy_u8]
  given ByteCodec[EntityRemoveEffect] = autogenerateFor[EntityRemoveEffect]
  given ByteCodec[EntityRemoveEffect_i32] = autogenerateFor[EntityRemoveEffect_i32]
  given ByteCodec[ResourcePackSend] = autogenerateFor[ResourcePackSend]
  given ByteCodec[Respawn_Gamemode] = autogenerateFor[Respawn_Gamemode]
  given ByteCodec[Respawn_HashedSeed] = autogenerateFor[Respawn_HashedSeed]
  given ByteCodec[Respawn_NBT] = autogenerateFor[Respawn_NBT]
  given ByteCodec[Respawn_WorldName] = autogenerateFor[Respawn_WorldName]
  given ByteCodec[EntityHeadLook] = autogenerateFor[EntityHeadLook]
  given ByteCodec[EntityHeadLook_i32] = autogenerateFor[EntityHeadLook_i32]
  given ByteCodec[EntityStatus] = autogenerateFor[EntityStatus]
  given ByteCodec[NBTQueryResponse] = autogenerateFor[NBTQueryResponse]
  given ByteCodec[SelectAdvancementTab] = autogenerateFor[SelectAdvancementTab]
  given ByteCodec[ActionBar] = autogenerateFor[ActionBar]
  given ByteCodec[WorldBorder] = autogenerateFor[WorldBorder]
  given ByteCodec[WorldBorderInitialize] = autogenerateFor[WorldBorderInitialize]
  given ByteCodec[WorldBorderCenter] = autogenerateFor[WorldBorderCenter]
  given ByteCodec[WorldBorderLerpSize] = autogenerateFor[WorldBorderLerpSize]
  given ByteCodec[WorldBorderSize]  = autogenerateFor[WorldBorderSize]
  given ByteCodec[WorldBorderWarningDelay] = autogenerateFor[WorldBorderWarningDelay]
  given ByteCodec[WorldBorderWarningReach] = autogenerateFor[WorldBorderWarningReach]
  given ByteCodec[Camera] = autogenerateFor[Camera]
  given ByteCodec[SetCurrentHotbarSlot] = autogenerateFor[SetCurrentHotbarSlot]
  given ByteCodec[UpdateViewPosition] = autogenerateFor[UpdateViewPosition]
  given ByteCodec[UpdateViewDistance] = autogenerateFor[UpdateViewDistance]
  given ByteCodec[ScoreboardDisplay] = autogenerateFor[ScoreboardDisplay]
  given ByteCodec[EntityMetadata] = autogenerateFor[EntityMetadata]
  given ByteCodec[EntityMetadata_i32] = autogenerateFor[EntityMetadata_i32]
  given ByteCodec[EntityAttach] = autogenerateFor[EntityAttach]
  given ByteCodec[EntityAttach_leashed] = autogenerateFor[EntityAttach_leashed]
  given ByteCodec[EntityVelocity] = autogenerateFor[EntityVelocity]
  given ByteCodec[EntityVelocity_i32] = autogenerateFor[EntityVelocity_i32]
  given ByteCodec[EntityEquipment_Array] = autogenerateFor[EntityEquipment_Array]
  given ByteCodec[EntityEquipment_u16] = autogenerateFor[EntityEquipment_u16]
  given ByteCodec[EntityEquipment_u16_i32] = autogenerateFor[EntityEquipment_u16_i32]
  given ByteCodec[SetExperience] = autogenerateFor[SetExperience]
  given ByteCodec[SetExperience_i16] = autogenerateFor[SetExperience_i16]
  given ByteCodec[UpdateHealth] = autogenerateFor[UpdateHealth]
  given ByteCodec[UpdateHealth_u16] = autogenerateFor[UpdateHealth_u16]
  given ByteCodec[ScoreboardObjective] = autogenerateFor[ScoreboardObjective]
  given ByteCodec[ScoreboardObjective_NoMode] = autogenerateFor[ScoreboardObjective_NoMode]
  given ByteCodec[SetPassengers] = autogenerateFor[SetPassengers]
  given ByteCodec[Teams_VarInt] = autogenerateFor[Teams_VarInt]
  given ByteCodec[Teams_u8] = autogenerateFor[Teams_u8]
  given ByteCodec[Teams_NoVisColor] = autogenerateFor[Teams_NoVisColor]
  given ByteCodec[UpdateScore] = autogenerateFor[UpdateScore]
  given ByteCodec[UpdateScore_i32] = autogenerateFor[UpdateScore_i32]
  given ByteCodec[SpawnPosition] = autogenerateFor[SpawnPosition]
  given ByteCodec[SpawnPosition_i32] = autogenerateFor[SpawnPosition_i32]
  given ByteCodec[SpawnPositionWithAngle] = autogenerateFor[SpawnPositionWithAngle]
  given ByteCodec[TimeUpdate] = autogenerateFor[TimeUpdate]
  given ByteCodec[StopSound] = autogenerateFor[StopSound]
  given ByteCodec[Title] = autogenerateFor[Title]
  given ByteCodec[Title_notext] = autogenerateFor[Title_notext]
  given ByteCodec[Title_notext_component] = autogenerateFor[Title_notext_component]
  given ByteCodec[Title_onlytext] = autogenerateFor[Title_onlytext]
  given ByteCodec[SubTitle] = autogenerateFor[SubTitle]
  given ByteCodec[TitleFade] = autogenerateFor[TitleFade]
  given ByteCodec[ClearTitle] = autogenerateFor[ClearTitle]
  given ByteCodec[UpdateSign] = autogenerateFor[UpdateSign]
  given ByteCodec[UpdateSign_u16] = autogenerateFor[UpdateSign_u16]
  given ByteCodec[SoundEffect] = autogenerateFor[SoundEffect]
  given ByteCodec[SoundEffect_u8] = autogenerateFor[SoundEffect_u8]
  given ByteCodec[EntitySoundEffect] = autogenerateFor[EntitySoundEffect]
  given ByteCodec[PlayerListHeaderFooter] = autogenerateFor[PlayerListHeaderFooter]
  given ByteCodec[CollectItem] = autogenerateFor[CollectItem]
  given ByteCodec[CollectItem_nocount] = autogenerateFor[CollectItem_nocount]
  given ByteCodec[CollectItem_nocount_i32] = autogenerateFor[CollectItem_nocount_i32]
  given ByteCodec[EntityTeleport_f64] = autogenerateFor[EntityTeleport_f64]
  given ByteCodec[EntityTeleport_i32] = autogenerateFor[EntityTeleport_i32]
  given ByteCodec[EntityTeleport_i32_i32_NoGround] = autogenerateFor[EntityTeleport_i32_i32_NoGround]
  given ByteCodec[Advancements] = autogenerateFor[Advancements]
  given ByteCodec[EntityProperties] = autogenerateFor[EntityProperties]
  given ByteCodec[EntityProperties_i32] = autogenerateFor[EntityProperties_i32]
  given ByteCodec[EntityEffect] = autogenerateFor[EntityEffect]
  given ByteCodec[EntityEffect_i32] = autogenerateFor[EntityEffect_i32]
  given ByteCodec[DeclareRecipes] = autogenerateFor[DeclareRecipes]
  given ByteCodec[Tags] = autogenerateFor[Tags]
  given ByteCodec[TagsWithEntities] = autogenerateFor[TagsWithEntities]
  given ByteCodec[TagsWithTypes] = autogenerateFor[TagsWithTypes]
  given ByteCodec[AcknowledgePlayerDigging] = autogenerateFor[AcknowledgePlayerDigging]
  given ByteCodec[UpdateLight_WithTrust] = autogenerateFor[UpdateLight_WithTrust]
  given ByteCodec[UpdateLight_NoTrust] = autogenerateFor[UpdateLight_NoTrust]
  given ByteCodec[TradeList_WithoutRestock] = autogenerateFor[TradeList_WithoutRestock]
  given ByteCodec[TradeList_WithRestock] = autogenerateFor[TradeList_WithRestock]
  given ByteCodec[CoFHLib_SendUUID] = autogenerateFor[CoFHLib_SendUUID]
  given ByteCodec[LoginStart] = autogenerateFor[LoginStart]
  given ByteCodec[EncryptionResponse] = autogenerateFor[EncryptionResponse]
  given ByteCodec[EncryptionResponse_i16] = autogenerateFor[EncryptionResponse_i16]
  given ByteCodec[LoginPluginResponse] = autogenerateFor[LoginPluginResponse]
  given ByteCodec[LoginDisconnect] = autogenerateFor[LoginDisconnect]
  given ByteCodec[EncryptionRequest] = autogenerateFor[EncryptionRequest]
  given ByteCodec[EncryptionRequest_i16] = autogenerateFor[EncryptionRequest_i16]
  given ByteCodec[LoginSuccess_String] = autogenerateFor[LoginSuccess_String]
  given ByteCodec[LoginSuccess_UUID] = autogenerateFor[LoginSuccess_UUID]
  given ByteCodec[SetInitialCompression] = autogenerateFor[SetInitialCompression]
  given ByteCodec[LoginPluginRequest] = autogenerateFor[LoginPluginRequest]
  given ByteCodec[StatusRequest] = autogenerateFor[StatusRequest]
  given ByteCodec[StatusPing] = autogenerateFor[StatusPing]
  given ByteCodec[StatusResponse] = autogenerateFor[StatusResponse]
  given ByteCodec[StatusPong] = autogenerateFor[StatusPong]
  given ByteCodec[WindowItems_withState[Slot.Upto_1_17_1]] = autogenerateFor[WindowItems_withState[Slot.Upto_1_17_1]]
  given ByteCodec[SetSlot[Slot.Upto_1_17_1]] = autogenerateFor[SetSlot[Slot.Upto_1_17_1]]
  
  // region polymorphic givens
  private def clickWindow[S <: Slot: ByteCodec]: ByteCodec[ClickWindow[S]] = autogenerateFor[ClickWindow[S]]
  private def creativeInventoryActions[S <: Slot: ByteCodec]: ByteCodec[CreativeInventoryAction[S]] = autogenerateFor[CreativeInventoryAction[S]]
  private def windowSetSlot[S <: Slot: ByteCodec]: ByteCodec[WindowSetSlot[S]] = autogenerateFor[WindowSetSlot[S]]
  private def windowItems[T <: Slot: ByteCodec]: ByteCodec[WindowItems[T]] = autogenerateFor[WindowItems[T]]
  private def entityEquipment_VarInt[S <: Slot: ByteCodec]: ByteCodec[EntityEquipment_VarInt[S]] = autogenerateFor[EntityEquipment_VarInt[S]]

  // ...and their monomorphic instantiations
  given clickWindowUpto_1_12_2: ByteCodec[ClickWindow[Slot.Upto_1_12_2]] = clickWindow[Slot.Upto_1_12_2]
  given clickWindowUpto_1_17_1: ByteCodec[ClickWindow[Slot.Upto_1_17_1]] = clickWindow[Slot.Upto_1_17_1]

  given creativeInventoryActions_1_12_2: ByteCodec[CreativeInventoryAction[Slot.Upto_1_12_2]] = creativeInventoryActions[Slot.Upto_1_12_2]
  given creativeInventoryActions_1_17_1: ByteCodec[CreativeInventoryAction[Slot.Upto_1_17_1]] = creativeInventoryActions[Slot.Upto_1_17_1]

  given windowSetSlot_1_12_2: ByteCodec[WindowSetSlot[Slot.Upto_1_12_2]] = windowSetSlot[Slot.Upto_1_12_2]
  given windowSetSlot_1_17_1: ByteCodec[WindowSetSlot[Slot.Upto_1_17_1]] = windowSetSlot[Slot.Upto_1_17_1]

  given windowItems_1_12_2: ByteCodec[WindowItems[Slot.Upto_1_12_2]] = windowItems[Slot.Upto_1_12_2]
  given windowItems_1_17_1: ByteCodec[WindowItems[Slot.Upto_1_17_1]] = windowItems[Slot.Upto_1_17_1]

  given entityEquipment_VarInt_1_12_2: ByteCodec[EntityEquipment_VarInt[Slot.Upto_1_12_2]] = entityEquipment_VarInt[Slot.Upto_1_12_2]
  given entityEquipment_VarInt_1_17_1: ByteCodec[EntityEquipment_VarInt[Slot.Upto_1_17_1]] = entityEquipment_VarInt[Slot.Upto_1_17_1]
  // endregion

  // region Position-dependent codecs
  given sculkVibrationSignal(using pc: ByteCodec[Position]): ByteCodec[SculkVibrationSignal] =
    autogenerateFor[SculkVibrationSignal]
  // endregion
  
  // format: on
}
