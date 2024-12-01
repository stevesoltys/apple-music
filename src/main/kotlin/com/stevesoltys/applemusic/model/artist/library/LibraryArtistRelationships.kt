package com.stevesoltys.applemusic.model.artist.library

import com.stevesoltys.applemusic.model.Relationship

/**
 * @author Steve Soltys
 */
data class LibraryArtistRelationships(
  val catalog: LibraryArtistCatalogRelationship? = null
) : Relationship()
