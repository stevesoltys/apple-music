package com.stevesoltys.applemusic.model.libraryartist

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
data class LibraryArtistResponse(
  val data: List<LibraryArtist>
) : ResponseRoot()
