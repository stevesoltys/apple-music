package com.stevesoltys.applemusic.net

import com.stevesoltys.applemusic.AppleMusicConfiguration
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * @author Steve Soltys
 */
interface AppleMusicRetrofitBuilder {

  fun build(configuration: AppleMusicConfiguration, token: String): Retrofit
}
