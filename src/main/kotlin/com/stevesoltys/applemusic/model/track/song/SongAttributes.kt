package com.stevesoltys.applemusic.model.track.song

import com.fasterxml.jackson.annotation.JsonProperty
import com.stevesoltys.applemusic.model.Artwork
import com.stevesoltys.applemusic.model.EditorialNotes

/**
 * @author Steve Soltys
 */
class SongAttributes {

  var albumName: String? = null

  var artistName: String? = null

  var artwork: Artwork? = null

  var composerName: String? = null

  var contentRating: String? = null

  var discNumber: Int? = null

  var durationInMillis: Long? = null

  var editorialNotes: EditorialNotes? = null

  var genreNames: Array<String>? = null

  var isrc: String? = null

  var movementCount: Int? = null

  var movementName: String? = null

  var movementNumber: Int? = null

  var name: String? = null

  // TODO: Play parameters

  // TODO: Previews

  var releaseDate: String? = null

  var trackNumber: Int? = null

  var url: String? = null

  var workName: String? = null
}
