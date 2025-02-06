package com.github.sawafrolov.fastpizza.common.dto.iam

import jakarta.validation.constraints.*
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable

/**
 * DTO регистрации пользователя
 */
@Serializable
data class RegistrationDto(

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
     * Номер телефона
     */
    @Nullable
    val phoneNumber: String?,

    /**
     * Имя
     */
    @Nullable
    val firstName: String?
)
