package com.stevesoltys.applemusic.model.artist

import com.stevesoltys.applemusic.model.Artwork
import com.stevesoltys.applemusic.model.EditorialNotes

/**
 * @author Steve Soltys
 */
class ArtistAttributes {

  var artwork: Artwork? = null

  var editorialNotes: EditorialNotes? = null

  var genreNames: Array<String>? = null

  var name: String? = null

  var url: String? = null
}
