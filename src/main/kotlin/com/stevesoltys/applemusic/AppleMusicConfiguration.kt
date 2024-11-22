package com.stevesoltys.applemusic

/**
 * @author Steve Soltys
 */
class AppleMusicConfiguration(
  val teamId: String,
  val privateKey: ByteArray,
  val keyId: String,
  val storefront: String,
  val baseUrl: String = "https://api.music.apple.com/v1/"
)
