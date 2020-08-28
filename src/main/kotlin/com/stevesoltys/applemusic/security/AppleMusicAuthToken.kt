package com.stevesoltys.applemusic.security

import java.util.Date

/**
 * @author Steve Soltys
 */
class AppleMusicAuthToken(
    private val expiryDate: Date,
    val token: String
) {

    fun isExpired(): Boolean {
        return Date().toInstant().isAfter(expiryDate.toInstant())
    }

    override fun toString(): String {
        return token
    }
}