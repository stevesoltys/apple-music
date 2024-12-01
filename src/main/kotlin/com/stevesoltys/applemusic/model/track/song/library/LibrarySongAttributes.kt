package com.stevesoltys.applemusic.model.track.song.library

import com.stevesoltys.applemusic.model.Artwork
import com.stevesoltys.applemusic.model.PlayParameters

/**
 * @author Steve Soltys
 */
data class LibrarySongAttributes(
  val albumName: String? = null,
  val artistName: String,
  val artwork: Artwork,
  val contentRating: String? = null,
  val discNumber: Int? = null,
  val durationInMillis: Int,
  val genreNames: List<String>,
  val hasLyrics: Boolean,
  val name: String,
  val playParams: PlayParameters? = null,
  val releaseDate: String? = null,
  val trackNumber: Int? = null
)
