package com.stevesoltys.applemusic.net

import com.stevesoltys.applemusic.model.album.AlbumResponse
import com.stevesoltys.applemusic.model.artist.ArtistResponse
import com.stevesoltys.applemusic.model.search.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Steve Soltys
 */
interface AppleMusicService {

    @GET("search")
    fun search(
        @Query("term") term: String,
        @Query("offset") offset: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("include") types: Array<String>? = null
    ): Call<SearchResponse>

    @GET("artists/{id}")
    fun getArtistById(
        @Path("id") id: String,
        @Query("include") types: Array<String>? = null
    ): Call<ArtistResponse>

    @GET("artists")
    fun getArtistsById(@Query("ids") ids: Array<String>): Call<ArtistResponse>

    @GET("albums/{id}")
    fun getAlbumById(
        @Path("id") id: String,
        @Query("include") types: Array<String>? = null
    ): Call<AlbumResponse>

    @GET("albums")
    fun getAlbumsById(@Query("ids") ids: Array<String>): Call<AlbumResponse>

    @GET("artists/{id}/albums")
    fun getAlbumsByArtistId(
        @Path("id") id: String,
        @Query("offset") offset: String? = null,
        @Query("limit") limit: Int? = null
    ): Call<AlbumResponse>
}