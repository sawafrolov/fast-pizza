package com.github.sawafrolov.fastpizza.starter

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.github.sawafrolov.fastpizza.starter.exceptions.UnauthorizedException
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

private val secret = "secret"
private val algorithm = Algorithm.HMAC256(secret)
private val audience = "http://localhost:8080/"
private val issuer = "http://localhost:8080/"


private val jwtVerifier: JWTVerifier = JWT
    .require(algorithm)
    .withAudience(audience)
    .withIssuer(issuer)
    .build()

fun Application.configureAuth() {
    install(Authentication) {
        jwt("auth-jwt") {
            realm = "fast-pizza"
            verifier(jwtVerifier)

            challenge { _, _ ->
                throw UnauthorizedException("Token is not valid or has expired")
            }
        }
    }
}
