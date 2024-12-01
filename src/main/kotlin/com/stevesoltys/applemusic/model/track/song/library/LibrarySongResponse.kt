package com.stevesoltys.applemusic.model.track.song.library

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
data class LibrarySongResponse(
  val data: List<LibrarySong>
) : ResponseRoot()
