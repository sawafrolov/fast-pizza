package com.github.sawafrolov.fastpizza.starter

import com.github.sawafrolov.fastpizza.starter.exceptions.ForbiddenException
import com.github.sawafrolov.fastpizza.starter.exceptions.UnauthorizedException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

private val jsonContentType = ContentType.Application.Json

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            val defaultMessage = when(cause) {
                is BadRequestException -> "Bad Request"
                is UnauthorizedException -> "Unauthorized"
                is ForbiddenException -> "Forbidden"
                is NotFoundException -> "Not Found"
                else -> "Internal Server Error"
            }
            val statusCode = when(cause) {
                is BadRequestException -> HttpStatusCode.BadRequest
                is UnauthorizedException -> HttpStatusCode.Unauthorized
                is ForbiddenException -> HttpStatusCode.Forbidden
                is NotFoundException -> HttpStatusCode.NotFound
                else -> HttpStatusCode.InternalServerError
            }
            call.respondText(
                cause.message ?: defaultMessage,
                contentType = jsonContentType,
                status = statusCode
            )
        }
    }
}
