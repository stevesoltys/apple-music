package com.stevesoltys.applemusic.model.track.song

import com.stevesoltys.applemusic.model.track.Track

/**
 * @author Steve Soltys
 */
class Song : Track() {

  var relationships: SongRelationships? = null

  var attributes: SongAttributes? = null
}
