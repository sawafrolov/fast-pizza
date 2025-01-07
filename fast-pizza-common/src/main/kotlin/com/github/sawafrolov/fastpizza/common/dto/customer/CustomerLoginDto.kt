package com.github.sawafrolov.fastpizza.common.dto.customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable

/**
 * DTO для входа в приложение
 */
@Serializable
data class CustomerLoginDto(

    /**
     * Адрес электронной почты
     */
    @field:Email
    @field:NotBlank
    val email: String,

    /**
     * Пароль
     */
    @field:NotBlank
    @field:Size(min = 8, max = 32)
    @field:Pattern(regexp = "^\\S+$")
    val password: String
)
