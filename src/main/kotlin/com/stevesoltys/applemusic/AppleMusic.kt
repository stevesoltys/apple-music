package com.stevesoltys.applemusic

import com.stevesoltys.applemusic.model.album.AlbumResponse
import com.stevesoltys.applemusic.model.artist.ArtistResponse
import com.stevesoltys.applemusic.model.chart.ChartResponse
import com.stevesoltys.applemusic.model.chart.ChartResultType
import com.stevesoltys.applemusic.model.chart.ChartType
import com.stevesoltys.applemusic.model.album.library.LibraryAlbumResponse
import com.stevesoltys.applemusic.model.artist.library.LibraryArtistResponse
import com.stevesoltys.applemusic.model.search.SearchResponse
import com.stevesoltys.applemusic.model.search.SearchResultType
import com.stevesoltys.applemusic.model.track.song.library.LibrarySongResponse
import com.stevesoltys.applemusic.net.AppleMusicHttpException
import com.stevesoltys.applemusic.net.AppleMusicRetrofitBuilder
import com.stevesoltys.applemusic.net.AppleMusicService
import com.stevesoltys.applemusic.net.DefaultAppleMusicRetrofitBuilder
import com.stevesoltys.applemusic.security.AppleMusicAuthToken
import com.stevesoltys.applemusic.security.AppleMusicTokenGenerator
import retrofit2.Call

/**
 * @author Steve Soltys
 */
class AppleMusic(
  private val configuration: AppleMusicConfiguration,
  private val retrofitBuilder: AppleMusicRetrofitBuilder? = null
) {

  private val retrofit: AppleMusicRetrofitBuilder by lazy {
    retrofitBuilder ?: DefaultAppleMusicRetrofitBuilder()
  }

  private var currentToken: AppleMusicAuthToken? = null

  private val appleMusicService: AppleMusicService
    get() {
      return retrofit
        .build(configuration, token().toString())
        .create(AppleMusicService::class.java)
    }

  private fun token(): AppleMusicAuthToken {

    if (currentToken == null || currentToken!!.isExpired()) {
      currentToken = AppleMusicTokenGenerator(configuration).generate()
    }

    return currentToken!!
  }

  /**
   * Perform a catalog search.
   */
  fun search(
    term: String,
    offset: String? = null,
    limit: Int? = null,
    types: Set<SearchResultType>? = null
  ): SearchResponse {
    return call(
      appleMusicService.search(
        storefront = configuration.storefront,
        term = term,
        offset = offset,
        limit = limit,
        types = types?.map { it.identifier }?.toTypedArray()
      )
    )
  }

  /**
   * Get catalog charts.
   */
  fun getCatalogCharts(
    types: Set<ChartResultType>,
    localization: String? = null,
    chart: String? = null,
    offset: String? = null,
    limit: Int? = null,
    genre: String? = null,
    with: Set<ChartType>? = null
  ): ChartResponse {
    return call(
      appleMusicService.getCatalogCharts(
        storefront = configuration.storefront,
        types = types.map { it.identifier }.toTypedArray(),
        localization = localization,
        chart = chart,
        offset = offset,
        limit = limit,
        genre = genre,
        with = with?.map { it.identifier }?.toTypedArray()
      )
    )
  }

  /**
   * Get an artist.
   */
  fun getArtistById(
    id: String,
    include: Set<String>? = null
  ): ArtistResponse {
    return call(
      appleMusicService.getArtistById(
        storefront = configuration.storefront,
        id = id,
        types = include?.toTypedArray()
      )
    )
  }

  /**
   * Get an album.
   */
  fun getAlbumById(
    id: String,
    include: Set<String>? = null
  ): AlbumResponse {
    return call(
      appleMusicService.getAlbumById(
        storefront = configuration.storefront,
        id = id,
        types = include?.toTypedArray()
      )
    )
  }

  /**
   * Get a set of albums by their identifiers.
   */
  fun getAlbumsById(
    ids: Array<String>
  ): AlbumResponse {
    return call(
      appleMusicService.getAlbumsById(
        storefront = configuration.storefront,
        ids = ids
      )
    )
  }

  /**
   * Get a set of artists by their identifiers.
   */
  fun getArtistsById(
    ids: Array<String>
  ): ArtistResponse {
    return call(
      appleMusicService.getArtistsById(
        storefront = configuration.storefront,
        ids = ids
      )
    )
  }

  /**
   * Get albums for a given artist.
   */
  fun getAlbumsByArtistId(
    id: String,
    offset: String? = null,
    limit: Int? = null
  ): AlbumResponse {
    return call(
      appleMusicService.getAlbumsByArtistId(
        storefront = configuration.storefront,
        id = id,
        offset = offset,
        limit = limit
      )
    )
  }

  /**
   * Get all albums for a given artist.
   */
  fun getAllAlbumsByArtistId(id: String): AlbumResponse {
    val limit = 100
    var offset = 0

    var currentResponse = call(
      appleMusicService.getAlbumsByArtistId(
        storefront = configuration.storefront,
        id = id,
        offset = 0.toString(),
        limit = limit
      )
    )

    val result = currentResponse.data.toCollection(ArrayList())

    while (currentResponse.next != null) {
      offset += currentResponse.data.size

      currentResponse = getAlbumsByArtistId(
        id = id,
        offset = offset.toString(),
        limit = limit
      )

      result.addAll(currentResponse.data)
    }

    return AlbumResponse(result.toTypedArray())
  }

  /**
   * Get all artists from a user's library.
   */
  fun getLibraryArtists(
    userToken: String,
    include: Set<String>? = null,
    localization: String? = null,
    limit: Int? = null,
    offset: String? = null,
    extend: Set<String>? = null
  ): LibraryArtistResponse {

    return call(
      appleMusicService.getLibraryArtists(
        userToken = userToken,
        include = include?.toTypedArray(),
        localization = localization,
        limit = limit,
        offset = offset,
        extend = extend?.toTypedArray()
      )
    )
  }

  /**
   * Get all albums from a user's library.
   */
  fun getLibraryAlbums(
    userToken: String,
    include: Set<String>? = null,
    localization: String? = null,
    limit: Int? = null,
    offset: String? = null,
    extend: Set<String>? = null
  ): LibraryAlbumResponse {

    return call(
      appleMusicService.getLibraryAlbums(
        userToken = userToken,
        include = include?.toTypedArray(),
        localization = localization,
        limit = limit,
        offset = offset,
        extend = extend?.toTypedArray()
      )
    )
  }

  /**
   * Get all songs from a user's library.
   */
  fun getLibrarySongs(
    userToken: String,
    include: Set<String>? = null,
    localization: String? = null,
    limit: Int? = null,
    offset: String? = null,
    extend: Set<String>? = null
  ): LibrarySongResponse {

    return call(
      appleMusicService.getLibrarySongs(
        userToken = userToken,
        include = include?.toTypedArray(),
        localization = localization,
        limit = limit,
        offset = offset,
        extend = extend?.toTypedArray()
      )
    )
  }

  private fun <T> call(call: Call<T>): T {
    val response = call.execute()

    if (response.isSuccessful) {
      return response.body()
        ?: throw IllegalStateException("Body should be present when call is successful.")
    }

    throw AppleMusicHttpException(response)
  }
}
