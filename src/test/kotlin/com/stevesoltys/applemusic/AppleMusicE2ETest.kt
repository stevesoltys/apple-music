package com.stevesoltys.applemusic

import com.stevesoltys.applemusic.model.chart.ChartResultType
import com.stevesoltys.applemusic.model.chart.ChartType
import com.stevesoltys.applemusic.model.search.SearchResultType
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppleMusicE2ETest {

    companion object {
        private val TEAM_ID = System.getenv("TEAM_ID")
        private val PRIVATE_KEY_BASE64 = System.getenv("PRIVATE_KEY_BASE64")
        private val KEY_ID = System.getenv("KEY_ID")
        private const val STOREFRONT = "us"

        private const val TEST_ARTIST_IDENTIFIER = "485953"
        private const val TEST_ARTIST_NAME = "Billy Joel"

        private const val TEST_ALBUM_IDENTIFIER = "259814641"
        private const val TEST_ALBUM_NAME = "An Innocent Man"

        private const val TEST_ALBUM_IDENTIFIER_2 = "1440903530"
    }

    private lateinit var appleMusic: AppleMusic

    @BeforeAll
    fun `set up`() {
        appleMusic = AppleMusic(
            teamId = TEAM_ID,
            privateKey = Base64.getDecoder().decode(PRIVATE_KEY_BASE64),
            keyId = KEY_ID,
            storefront = STOREFRONT
        )
    }

    @Test
    fun `can search for artists`() {
        val result = appleMusic.search(
            TEST_ARTIST_NAME,
            types = setOf(SearchResultType.ARTISTS)
        )

        val artists = result.results?.artists?.data
        artists shouldNotBe null
        artists!!.size shouldBeGreaterThan 0
    }

    @Test
    fun `can get artist by identifier`() {
        val result = appleMusic.getArtistById(TEST_ARTIST_IDENTIFIER)

        val billyJoelAttributes = result.data.firstOrNull()?.attributes
        billyJoelAttributes.shouldNotBeNull()
        billyJoelAttributes.name shouldBe TEST_ARTIST_NAME
    }

    @Test
    fun `can get a single album by identifier`() {
        val result = appleMusic.getAllAlbumsByArtistId(TEST_ARTIST_IDENTIFIER)

        val albums = result.data
        albums.shouldNotBeNull().shouldNotBeEmpty()
    }

    @Test
    fun `can get multiple albums by their identifiers`() {
        val result = appleMusic.getAlbumsById(
            arrayOf(TEST_ALBUM_IDENTIFIER, TEST_ALBUM_IDENTIFIER_2)
        )

        val albums = result.data
        albums.shouldNotBeNull().shouldNotBeEmpty()

        albums.first().attributes?.artistName.shouldNotBeNull()
        albums.first().relationships?.artists?.data.shouldNotBeNull().shouldHaveSize(1)
    }

    @Test
    fun `can get album by identifier`() {
        val result = appleMusic.getAlbumById(TEST_ALBUM_IDENTIFIER)

        val artistAttributes = result.data.firstOrNull()?.attributes
        artistAttributes.shouldNotBeNull()
        artistAttributes.name shouldBe TEST_ALBUM_NAME
    }

    @Test
    fun `can get top 100 album charts`() {
        val result = appleMusic.getCatalogCharts(
            types = setOf(ChartResultType.ALBUMS),
            with = setOf(ChartType.DAILY_GLOBAL_TOP_CHARTS),
            limit = 100
        )

        result.results.albums.shouldNotBeEmpty()
        result.results.albums.first().data.shouldHaveSize(100)
        result.results.songs.shouldBeEmpty()
    }

    @Test
    fun `can get top 100 song charts`() {
        val result = appleMusic.getCatalogCharts(
            types = setOf(ChartResultType.SONGS),
            with = setOf(ChartType.DAILY_GLOBAL_TOP_CHARTS),
            limit = 100
        )

        result.results.songs.shouldNotBeEmpty()
        result.results.songs.first().data.shouldHaveSize(100)
        result.results.albums.shouldBeEmpty()
    }
}