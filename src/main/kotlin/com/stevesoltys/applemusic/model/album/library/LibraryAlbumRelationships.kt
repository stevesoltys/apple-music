package com.stevesoltys.applemusic.model.album.library

import com.stevesoltys.applemusic.model.Relationship

/**
 * @author Steve Soltys
 */
data class LibraryAlbumRelationships(
  val artists: LibraryAlbumArtistsRelationship? = null,
  val catalog: LibraryAlbumCatalogRelationship? = null
) : Relationship()
