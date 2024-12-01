package com.stevesoltys.applemusic.model.artist.library

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
data class LibraryArtistResponse(
  val data: List<LibraryArtist>
) : ResponseRoot()
