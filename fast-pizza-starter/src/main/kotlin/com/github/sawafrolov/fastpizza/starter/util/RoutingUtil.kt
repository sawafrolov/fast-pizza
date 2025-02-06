package com.github.sawafrolov.fastpizza.starter.util

import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.routing.*
import java.util.UUID

fun getUserId(call: RoutingCall): UUID =
    call
        .principal<JWTPrincipal>()!!
        .payload
        .getClaim("uuid")
        .asString()
        .let { UUID.fromString(it) }
