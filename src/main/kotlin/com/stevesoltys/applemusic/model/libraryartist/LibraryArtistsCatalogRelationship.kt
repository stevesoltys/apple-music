package com.stevesoltys.applemusic.model.libraryartist

import com.stevesoltys.applemusic.model.Resource

data class LibraryArtistsCatalogRelationship(
  val data: List<LibraryArtist>
) : Resource()
