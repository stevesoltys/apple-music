package com.stevesoltys.applemusic.model.album

import com.stevesoltys.applemusic.model.Resource

/**
 * @author Steve Soltys
 */
class Album : Resource() {

  var relationships: AlbumRelationships? = null

  var attributes: AlbumAttributes? = null
}
