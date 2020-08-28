package com.stevesoltys.applemusic.model.search

/**
 * @author Steve Soltys
 */
enum class SearchResultType(val identifier: String) {
    ACTIVITIES("activities"),
    ALBUMS("albums"),
    APPLE_CURATORS("appleCurators"),
    ARTISTS("artists"),
    CURATORS("curators"),
    MUSIC_VIDEOS("musicVideos"),
    PLAYLISTS("playlists"),
    SONGS("songs"),
    STATIONS("stations")
}