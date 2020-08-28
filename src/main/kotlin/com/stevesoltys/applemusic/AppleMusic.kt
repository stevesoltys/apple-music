package com.stevesoltys.applemusic

import com.stevesoltys.applemusic.model.search.SearchResponse
import com.stevesoltys.applemusic.net.AppleMusicHttpException
import com.stevesoltys.applemusic.net.AppleMusicRetrofitBuilder
import com.stevesoltys.applemusic.net.AppleMusicService
import com.stevesoltys.applemusic.security.AppleMusicAuthToken
import com.stevesoltys.applemusic.security.AppleMusicTokenGenerator
import retrofit2.Call

/**
 * @author Steve Soltys
 */
class AppleMusic(private val configuration: AppleMusicConfiguration) {

    private val tokenGenerator: AppleMusicTokenGenerator by lazy {
        AppleMusicTokenGenerator(configuration)
    }

    private var currentToken: AppleMusicAuthToken? = null

    private val appleMusicService: AppleMusicService
        get() {
            return AppleMusicRetrofitBuilder().build(configuration, token().toString())
                .create(AppleMusicService::class.java)
        }

    private fun token(): AppleMusicAuthToken {

        if (currentToken == null || currentToken!!.isExpired()) {
            currentToken = AppleMusicTokenGenerator(configuration).generate()
        }

        return currentToken!!
    }

    fun search(
        term: String,
        offset: String? = null,
        limit: Int? = null,
        types: Array<String>? = null
    ): SearchResponse {
        return call(appleMusicService.search(term, offset, limit, types))
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