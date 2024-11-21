package com.stevesoltys.applemusic.model.track.song

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
open class SongResponse(
  val data: Array<Song> = emptyArray()
) : ResponseRoot()
