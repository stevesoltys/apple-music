package com.stevesoltys.applemusic.model.artist.library

import com.stevesoltys.applemusic.model.Resource
import com.stevesoltys.applemusic.model.artist.Artist

data class LibraryArtistCatalogRelationship(
  val data: List<Artist>
) : Resource()
