package com.stevesoltys.applemusic.model.track.song

class SongChartResponse(
  val chart: String,
  val name: String,
  data: Array<Song> = emptyArray()
) : SongResponse(data)
