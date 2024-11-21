package com.stevesoltys.applemusic.net

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

/**
 * @author Steve Soltys
 */
class AppleMusicObjectMapper : ObjectMapper() {
  init {
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    registerModule(
      KotlinModule.Builder()
        .build()
    )
  }
}
