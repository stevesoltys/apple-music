package com.stevesoltys.applemusic.security

import com.stevesoltys.applemusic.AppleMusicConfiguration
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.security.KeyFactory
import java.security.spec.PKCS8EncodedKeySpec
import java.time.temporal.ChronoUnit
import java.util.Date

/**
 * @author Steve Soltys
 */
class AppleMusicTokenGenerator(private val configuration: AppleMusicConfiguration) {

    fun generate(): AppleMusicAuthToken {
        val issueDate = Date()
        val expiryDate = Date.from(Date().toInstant().plus(15777000, ChronoUnit.SECONDS))

        val token = Jwts.builder()
            .setIssuer(configuration.teamId)
            .setIssuedAt(issueDate)
            .setExpiration(expiryDate)
            .setHeaderParam("kid", configuration.keyId)
            .signWith(
                KeyFactory.getInstance("EC")
                    .generatePrivate(PKCS8EncodedKeySpec(configuration.privateKey)),
                SignatureAlgorithm.ES256
            )
            .compact()

        return AppleMusicAuthToken(
            expiryDate = expiryDate,
            token = token
        )
    }
}