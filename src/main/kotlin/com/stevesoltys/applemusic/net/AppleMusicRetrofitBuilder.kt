package com.stevesoltys.applemusic.net

import com.stevesoltys.applemusic.AppleMusicConfiguration
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * @author Steve Soltys
 */
class AppleMusicRetrofitBuilder {

    fun build(configuration: AppleMusicConfiguration, token: String): Retrofit {
        val objectMapper = AppleMusicObjectMapper()

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest: Request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()

                chain.proceed(newRequest)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.music.apple.com/v1/catalog/${configuration.storefront}/")
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()
    }
}