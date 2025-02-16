package com.github.sawafrolov.fastpizza.starter

import com.github.sawafrolov.fastpizza.common.util.jwt.jwtRealm
import com.github.sawafrolov.fastpizza.common.util.jwt.jwtVerifier
import com.github.sawafrolov.fastpizza.starter.exceptions.UnauthorizedException
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.configureAuth() {

    install(Authentication) {
        jwt("auth-jwt") {
            realm = jwtRealm
            verifier(jwtVerifier)

            validate { credential ->
                val uuidClaim = credential.payload.getClaim("uuid")
                if (uuidClaim.isNull || uuidClaim.isMissing || uuidClaim.asString().isBlank()) {
                    throw UnauthorizedException("JWT claim is missing")
                }
                JWTPrincipal(credential.payload)
            }

            challenge { _, _ ->
                throw UnauthorizedException("Token is not valid or has expired")
            }
        }
    }
}
