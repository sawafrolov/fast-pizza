package com.github.sawafrolov.fastpizza.common.util.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import java.time.Instant
import java.util.UUID

private const val secret = "secret"
private const val audience = "http://localhost:8080/"
private const val issuer = "http://localhost:8080/"
private const val expirationTimeInSeconds = 300L
private val algorithm = Algorithm.HMAC256(secret)

const val jwtRealm = "fast-pizza"

val jwtVerifier: JWTVerifier = JWT
    .require(algorithm)
    .withAudience(audience)
    .withIssuer(issuer)
    .build()

fun createAuthToken(userId: UUID): String {
    val expirationTime = Instant.now().plusSeconds(expirationTimeInSeconds)
    return JWT.create()
        .withAudience(audience)
        .withIssuer(issuer)
        .withClaim("uuid", userId.toString())
        .withExpiresAt(expirationTime)
        .sign(Algorithm.HMAC256(secret))
}
