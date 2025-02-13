package com.github.sawafrolov.fastpizza.starter.util

import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.routing.*
import java.util.UUID

fun RoutingCall.getUserId(): UUID =
    this
        .principal<JWTPrincipal>()!!
        .payload
        .getClaim("uuid")
        .asString()
        .let { UUID.fromString(it) }

fun RoutingCall.getPathParamId(): UUID =
    this
        .pathParameters["id"]!!
        .let { UUID.fromString(it) }
