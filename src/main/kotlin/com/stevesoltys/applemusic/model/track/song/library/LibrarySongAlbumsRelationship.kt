package com.stevesoltys.applemusic.model.track.song.library

import com.stevesoltys.applemusic.model.Relationship
import com.stevesoltys.applemusic.model.album.library.LibraryAlbum
import com.stevesoltys.applemusic.model.artist.library.LibraryArtist

data class LibrarySongAlbumsRelationship(
  val data: List<LibraryAlbum>
) : Relationship()
