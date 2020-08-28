package com.stevesoltys.applemusic.model.album

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * @author Steve Soltys
 */
class AlbumAttributes {

    // TODO: Editorial notes

    @JsonProperty("albumName")
    var musicVideoAlbumName: String? = null

    var artistName: String? = null

    var contentRating: String? = null

    var copyright: String? = null

    var genreNames: Array<String>? = null

    @JsonProperty("isComplete")
    var complete: Boolean? = null

    @JsonProperty("isSingle")
    var single: Boolean? = null

    var name: String? = null

    // TODO: Play params

    var recordLabel: String? = null

    var releaseDate: String? = null

    var trackCount: Int? = null

    var url: String? = null

    @JsonProperty("isMasteredForItunes")
    var masteredForItunes: Boolean? = null
}