package com.stevesoltys.applemusic.model.track.song.library

import com.stevesoltys.applemusic.model.Relationship

/**
 * @author Steve Soltys
 */
data class LibrarySongRelationships(
  val albums: LibrarySongAlbumsRelationship? = null,
  val artists: LibrarySongArtistsRelationship? = null,
  val catalog: LibrarySongCatalogRelationship? = null
) : Relationship()
