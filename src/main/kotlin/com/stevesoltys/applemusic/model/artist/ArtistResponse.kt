package com.stevesoltys.applemusic.model.artist

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
class ArtistResponse : ResponseRoot() {

    lateinit var data: Array<Artist>
}