package com.stevesoltys.applemusic.model.chart

import com.stevesoltys.applemusic.model.album.AlbumChartResponse
import com.stevesoltys.applemusic.model.track.song.SongChartResponse

/**
 * @author Steve Soltys
 */
class ChartResults(
  val albums: Array<AlbumChartResponse> = emptyArray(),
  val songs: Array<SongChartResponse> = emptyArray()
)
