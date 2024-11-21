package com.stevesoltys.applemusic.model.libraryartist

import com.stevesoltys.applemusic.model.Resource

/**
 * @author Steve Soltys
 */
data class LibraryArtist(
  val attributes: LibraryArtistAttributes? = null,
  val relationships: LibraryArtistRelationships? = null
) : Resource()
