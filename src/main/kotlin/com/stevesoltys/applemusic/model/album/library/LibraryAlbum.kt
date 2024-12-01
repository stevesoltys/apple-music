package com.stevesoltys.applemusic.model.album.library

import com.stevesoltys.applemusic.model.Resource

/**
 * @author Steve Soltys
 */
data class LibraryAlbum(
  val attributes: LibraryAlbumAttributes? = null,
  val relationships: LibraryAlbumRelationships? = null
) : Resource()
