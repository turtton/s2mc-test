package com.github.kory33.s2mctest
package connection.protocol.data

enum SupportedProtocolVersions(intVersion: Int):
  case V754 extends SupportedProtocolVersions(754)
  case V753 extends SupportedProtocolVersions(753)
  case V751 extends SupportedProtocolVersions(751)
  case V736 extends SupportedProtocolVersions(736)
  case V735 extends SupportedProtocolVersions(735)
  case V578 extends SupportedProtocolVersions(578)
  case V575 extends SupportedProtocolVersions(575)
  case V498 extends SupportedProtocolVersions(498)
  case V490 extends SupportedProtocolVersions(490)
  case V485 extends SupportedProtocolVersions(485)
  case V480 extends SupportedProtocolVersions(480)
  case V477 extends SupportedProtocolVersions(477)
  case V452 extends SupportedProtocolVersions(452)
  case V451 extends SupportedProtocolVersions(451)
  case V404 extends SupportedProtocolVersions(404)
  case V340 extends SupportedProtocolVersions(340)
  case V316 extends SupportedProtocolVersions(316)
  case V315 extends SupportedProtocolVersions(315)
  case V210 extends SupportedProtocolVersions(210)
  case V109 extends SupportedProtocolVersions(109)
  case V107 extends SupportedProtocolVersions(107)
  case V74  extends SupportedProtocolVersions(74)
  case V47  extends SupportedProtocolVersions(47)
  case V5   extends SupportedProtocolVersions(5)