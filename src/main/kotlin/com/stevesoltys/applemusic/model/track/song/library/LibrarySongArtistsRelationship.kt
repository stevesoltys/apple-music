package com.stevesoltys.applemusic.model.track.song.library

import com.stevesoltys.applemusic.model.Relationship
import com.stevesoltys.applemusic.model.artist.library.LibraryArtist

data class LibrarySongArtistsRelationship(
  val data: List<LibraryArtist>
) : Relationship()
