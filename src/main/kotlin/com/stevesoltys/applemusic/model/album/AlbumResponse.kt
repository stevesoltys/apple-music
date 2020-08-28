package com.stevesoltys.applemusic.model.album

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
class AlbumResponse : ResponseRoot() {

    var data: Array<Album>? = null
}