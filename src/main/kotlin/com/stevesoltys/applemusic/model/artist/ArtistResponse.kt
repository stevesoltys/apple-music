package com.stevesoltys.applemusic.model.artist

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
data class ArtistResponse(
  val data: List<Artist>
) : ResponseRoot()
