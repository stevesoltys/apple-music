package com.stevesoltys.applemusic

import com.stevesoltys.applemusic.model.album.AlbumResponse
import com.stevesoltys.applemusic.model.artist.ArtistResponse
import com.stevesoltys.applemusic.model.chart.ChartResponse
import com.stevesoltys.applemusic.model.chart.ChartResultType
import com.stevesoltys.applemusic.model.chart.ChartType
import com.stevesoltys.applemusic.model.search.SearchResponse
import com.stevesoltys.applemusic.model.search.SearchResultType
import com.stevesoltys.applemusic.net.AppleMusicHttpException
import com.stevesoltys.applemusic.net.AppleMusicRetrofitBuilder
import com.stevesoltys.applemusic.net.AppleMusicService
import com.stevesoltys.applemusic.security.AppleMusicAuthToken
import com.stevesoltys.applemusic.security.AppleMusicTokenGenerator
import retrofit2.Call

/**
 * @author Steve Soltys
 */
class AppleMusic(
    private val teamId: String,
    private val privateKey: ByteArray,
    private val keyId: String,
    private val storefront: String
) {

    private val configuration: AppleMusicConfiguration by lazy {
        AppleMusicConfiguration(teamId, privateKey, keyId, storefront)
    }

    private val retrofitBuilder: AppleMusicRetrofitBuilder by lazy {
        AppleMusicRetrofitBuilder()
    }

    private var currentToken: AppleMusicAuthToken? = null

    private val appleMusicService: AppleMusicService
        get() {
            return retrofitBuilder
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
                term,
                offset,
                limit,
                types?.map { it.identifier }?.toTypedArray()
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
        return call(appleMusicService.getArtistById(id, include?.toTypedArray()))
    }

    /**
     * Get an album.
     */
    fun getAlbumById(
        id: String,
        include: Set<String>? = null
    ): AlbumResponse {
        return call(appleMusicService.getAlbumById(id, include?.toTypedArray()))
    }

    /**
     * Get a set of albums by their identifiers.
     */
    fun getAlbumsById(
        ids: Array<String>
    ): AlbumResponse {
        return call(appleMusicService.getAlbumsById(ids))
    }

    /**
     * Get albums for a given artist.
     */
    fun getAlbumsByArtistId(
        id: String,
        offset: String? = null,
        limit: Int? = null
    ): AlbumResponse {
        return call(appleMusicService.getAlbumsByArtistId(id, offset, limit))
    }

    /**
     * Get all albums for a given artist.
     */
    fun getAllAlbumsByArtistId(id: String): AlbumResponse {
        val limit = 100
        var offset = 0

        var currentResponse = call(appleMusicService.getAlbumsByArtistId(id, 0.toString(), limit))
        val result = currentResponse.data.toCollection(ArrayList())

        while (currentResponse.next != null) {
            offset += currentResponse.data.size

            currentResponse = call(appleMusicService.getAlbumsByArtistId(id, offset.toString(), limit))
            result.addAll(currentResponse.data)
        }

        return AlbumResponse(result.toTypedArray())
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