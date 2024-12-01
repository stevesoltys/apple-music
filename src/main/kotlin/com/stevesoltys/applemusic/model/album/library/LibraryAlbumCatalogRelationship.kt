package com.stevesoltys.applemusic.model.album.library

import com.stevesoltys.applemusic.model.Relationship
import com.stevesoltys.applemusic.model.album.Album

data class LibraryAlbumCatalogRelationship(
  val data: List<Album>
) : Relationship()
