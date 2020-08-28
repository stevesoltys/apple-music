package com.stevesoltys.applemusic.model.album

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
class AlbumResponse : ResponseRoot() {

    lateinit var data: Array<Album>
}