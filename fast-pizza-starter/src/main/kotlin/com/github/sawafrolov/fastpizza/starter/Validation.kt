package com.github.sawafrolov.fastpizza.starter

import io.ktor.server.plugins.*
import jakarta.validation.Validator

fun Validator.validateDto(dto: Any, errorMessage: String) {
    val violations = this.validate(dto)
    if (violations.isNotEmpty()) {
        throw BadRequestException("$errorMessage: $violations")
    }
}
