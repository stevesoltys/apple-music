package com.stevesoltys.applemusic.net

import retrofit2.Response

/**
 * @author Steve Soltys
 */
class AppleMusicHttpException(val response: Response<*>) :
    RuntimeException(
        "Error during Apple Music HTTP call: " +
            "${response.message()} (${response.code()})"
    )