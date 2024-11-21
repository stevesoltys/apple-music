package com.stevesoltys.applemusic.model.album

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
open class AlbumResponse(
  val data: Array<Album> = emptyArray()
) : ResponseRoot()
