package com.github.sawafrolov.fastpizza.starter.util

import com.github.sawafrolov.fastpizza.starter.exceptions.ForbiddenException
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

fun RoutingCall.checkPathParamId() {
    val userId = this.getUserId()
    val pathParamId = this.getPathParamId()
    if (userId != pathParamId) {
        throw ForbiddenException("Path param does not belong to this user")
    }
}
