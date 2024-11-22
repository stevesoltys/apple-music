package com.stevesoltys.applemusic.model.libraryartist

import com.stevesoltys.applemusic.model.Resource
import com.stevesoltys.applemusic.model.artist.Artist

data class LibraryArtistsCatalogRelationship(
  val data: List<Artist>
) : Resource()
