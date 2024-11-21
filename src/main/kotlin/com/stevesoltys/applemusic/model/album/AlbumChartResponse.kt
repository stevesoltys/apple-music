package com.stevesoltys.applemusic.model.album

class AlbumChartResponse(
  val chart: String,
  val name: String,
  data: Array<Album> = emptyArray()
) : AlbumResponse(data)
