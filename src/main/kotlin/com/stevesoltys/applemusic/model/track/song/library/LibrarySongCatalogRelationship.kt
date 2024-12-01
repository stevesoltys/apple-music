package com.stevesoltys.applemusic.model.track.song.library

import com.stevesoltys.applemusic.model.Relationship
import com.stevesoltys.applemusic.model.Resource
import com.stevesoltys.applemusic.model.album.Album
import com.stevesoltys.applemusic.model.track.song.Song

data class LibrarySongCatalogRelationship(
  val data: List<Song>
) : Relationship()
