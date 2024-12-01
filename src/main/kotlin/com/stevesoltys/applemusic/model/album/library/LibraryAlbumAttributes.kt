package com.stevesoltys.applemusic.model.album.library

import com.stevesoltys.applemusic.model.Artwork
import com.stevesoltys.applemusic.model.PlayParameters

/**
 * @author Steve Soltys
 */
data class LibraryAlbumAttributes(
  val artistName: String,
  val artwork: Artwork,
  val contentRating: String? = null,
  val dateAdded: String? = null,
  val name: String,
  val playParams: PlayParameters? = null,
  val releaseDate: String? = null,
  val trackCount: Int,
  val genreNames: List<String>
)
