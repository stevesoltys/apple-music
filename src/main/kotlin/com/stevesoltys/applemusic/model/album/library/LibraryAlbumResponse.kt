package com.stevesoltys.applemusic.model.album.library

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
data class LibraryAlbumResponse(
  val data: List<LibraryAlbum>
) : ResponseRoot()
