package com.github.sawafrolov.fastpizza.common.dto.iam

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable

/**
 * DTO для смены пароля
 */
@Serializable
data class ChangePasswordDto(

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
    val password: String,

    /**
     * Новый пароль
     */
    @field:NotBlank
    @field:Size(min = 8, max = 32)
    @field:Pattern(regexp = "^\\S+$")
    val newPassword: String
)
