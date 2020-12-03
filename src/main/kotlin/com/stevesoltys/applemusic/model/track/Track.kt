package com.stevesoltys.applemusic.model.track

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.stevesoltys.applemusic.model.Resource
import com.stevesoltys.applemusic.model.track.musicvideo.MusicVideo
import com.stevesoltys.applemusic.model.track.song.Song

/**
 * @author Steve Soltys
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type"
)
@JsonSubTypes(
    value = [
        JsonSubTypes.Type(value = Song::class, name = "songs"),
        JsonSubTypes.Type(value = MusicVideo::class, name = "musicVideos")
    ]
)
abstract class Track : Resource()