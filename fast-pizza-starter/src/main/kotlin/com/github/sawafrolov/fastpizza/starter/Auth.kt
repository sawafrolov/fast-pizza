package com.github.sawafrolov.fastpizza.starter

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.github.sawafrolov.fastpizza.starter.exceptions.UnauthorizedException
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureAuth() {

    val secret = environment.config.property("jwt.secret").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val jwtRealm = environment.config.property("jwt.realm").getString()

    val jwtVerifier: JWTVerifier = JWT
        .require(Algorithm.HMAC256(secret))
        .withAudience(audience)
        .withIssuer(issuer)
        .build()

    install(Authentication) {
        jwt("auth-jwt") {
            realm = jwtRealm
            verifier(jwtVerifier)

            challenge { _, _ ->
                throw UnauthorizedException("Token is not valid or has expired")
            }
        }
    }
}
