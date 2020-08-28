package com.stevesoltys.applemusic.model.search

import com.stevesoltys.applemusic.model.ResponseRoot

/**
 * @author Steve Soltys
 */
class SearchResponse : ResponseRoot() {

    var results: SearchResults? = null
}