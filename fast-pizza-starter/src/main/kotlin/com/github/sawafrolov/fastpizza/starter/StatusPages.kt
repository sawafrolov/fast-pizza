package com.github.sawafrolov.fastpizza.starter

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
            when (cause) {
                is BadRequestException -> call.respondText(
                    cause.message ?: "Bad Request",
                    contentType = jsonContentType,
                    HttpStatusCode.BadRequest
                )
                is UnauthorizedException -> call.respondText(
                    cause.message ?: "Unauthorized",
                    contentType = jsonContentType,
                    HttpStatusCode.Unauthorized
                )
                is NotFoundException -> call.respondText(
                    cause.message ?: "Not found",
                    contentType = jsonContentType,
                    HttpStatusCode.NotFound
                )
                else -> call.respondText(
                    cause.message ?: "Internal Server Error: $cause",
                    contentType = jsonContentType,
                    HttpStatusCode.InternalServerError
                )
            }
        }
    }
}
