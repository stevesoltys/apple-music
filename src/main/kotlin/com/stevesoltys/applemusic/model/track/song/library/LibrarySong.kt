package com.stevesoltys.applemusic.model.track.song.library

import com.stevesoltys.applemusic.model.Resource

/**
 * @author Steve Soltys
 */
data class LibrarySong(
  val attributes: LibrarySongAttributes? = null,
  val relationships: LibrarySongRelationships? = null
) : Resource()
