package com.github.sawafrolov.fastpizza.customers.config

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

private val jsonContentType = ContentType.Application.Json

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            if (cause is BadRequestException) {
                call.respondText(cause.message ?: "Bad Request", contentType = jsonContentType, HttpStatusCode.BadRequest)
            }
            if (cause is NotFoundException) {
                call.respondText(cause.message ?: "Not Found", contentType = jsonContentType, HttpStatusCode.NotFound)
            } else {
                call.respondText("Internal Server Error: $cause", contentType = jsonContentType, HttpStatusCode.InternalServerError)
            }
        }
    }
}
