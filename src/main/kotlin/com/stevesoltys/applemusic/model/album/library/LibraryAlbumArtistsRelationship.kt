package com.stevesoltys.applemusic.model.album.library

import com.stevesoltys.applemusic.model.Relationship
import com.stevesoltys.applemusic.model.artist.library.LibraryArtist

data class LibraryAlbumArtistsRelationship(
  val data: List<LibraryArtist>
) : Relationship()
