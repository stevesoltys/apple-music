package com.stevesoltys.applemusic.net

import com.stevesoltys.applemusic.model.album.AlbumResponse
import com.stevesoltys.applemusic.model.artist.ArtistResponse
import com.stevesoltys.applemusic.model.chart.ChartResponse
import com.stevesoltys.applemusic.model.album.library.LibraryAlbumResponse
import com.stevesoltys.applemusic.model.artist.library.LibraryArtistResponse
import com.stevesoltys.applemusic.model.search.SearchResponse
import com.stevesoltys.applemusic.model.track.song.library.LibrarySongResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Steve Soltys
 */
interface AppleMusicService {

  @GET("catalog/{storefront}/search")
  fun search(
    @Path("storefront") storefront: String,
    @Query("term") term: String,
    @Query("offset") offset: String? = null,
    @Query("limit") limit: Int? = null,
    @Query("include") types: Array<String>? = null
  ): Call<SearchResponse>

  @GET("catalog/{storefront}/charts")
  fun getCatalogCharts(
    @Path("storefront") storefront: String,
    @Query("types") types: Array<String>,
    @Query("l") localization: String? = null,
    @Query("chart") chart: String? = null,
    @Query("offset") offset: String? = null,
    @Query("limit") limit: Int? = null,
    @Query("genre") genre: String? = null,
    @Query("with") with: Array<String>? = null
  ): Call<ChartResponse>

  @GET("catalog/{storefront}/artists/{id}")
  fun getArtistById(
    @Path("storefront") storefront: String,
    @Path("id") id: String,
    @Query("include") types: Array<String>? = null
  ): Call<ArtistResponse>

  @GET("catalog/{storefront}/artists")
  fun getArtistsById(
    @Path("storefront") storefront: String,
    @Query("ids") ids: Array<String>
  ): Call<ArtistResponse>

  @GET("catalog/{storefront}/albums/{id}")
  fun getAlbumById(
    @Path("storefront") storefront: String,
    @Path("id") id: String,
    @Query("include") types: Array<String>? = null
  ): Call<AlbumResponse>

  @GET("catalog/{storefront}/albums")
  fun getAlbumsById(
    @Path("storefront") storefront: String,
    @Query("ids") ids: Array<String>
  ): Call<AlbumResponse>

  @GET("catalog/{storefront}/artists/{id}/albums")
  fun getAlbumsByArtistId(
    @Path("storefront") storefront: String,
    @Path("id") id: String,
    @Query("offset") offset: String? = null,
    @Query("limit") limit: Int? = null
  ): Call<AlbumResponse>

  @GET("me/library/artists")
  fun getLibraryArtists(
    @Header("Music-User-Token") userToken: String,
    @Query("include") include: Array<String>? = null,
    @Query("l") localization: String? = null,
    @Query("limit") limit: Int? = null,
    @Query("offset") offset: String? = null,
    @Query("extend") extend: Array<String>? = null
  ): Call<LibraryArtistResponse>

  @GET("me/library/albums")
  fun getLibraryAlbums(
    @Header("Music-User-Token") userToken: String,
    @Query("include") include: Array<String>? = null,
    @Query("l") localization: String? = null,
    @Query("limit") limit: Int? = null,
    @Query("offset") offset: String? = null,
    @Query("extend") extend: Array<String>? = null
  ): Call<LibraryAlbumResponse>

  @GET("me/library/songs")
  fun getLibrarySongs(
    @Header("Music-User-Token") userToken: String,
    @Query("include") include: Array<String>? = null,
    @Query("l") localization: String? = null,
    @Query("limit") limit: Int? = null,
    @Query("offset") offset: String? = null,
    @Query("extend") extend: Array<String>? = null
  ): Call<LibrarySongResponse>
}
