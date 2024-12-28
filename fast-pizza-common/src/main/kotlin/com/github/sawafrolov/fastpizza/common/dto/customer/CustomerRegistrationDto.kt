package com.github.sawafrolov.fastpizza.common.dto.customer

import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable

/**
 * DTO регистрации пользователя
 */
@Serializable
data class CustomerRegistrationDto(

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
    val password: String,

    /**
     * Номер телефона
     */
    @field:NotBlank
    @field:Size(min = 10, max = 10)
    @field:Digits(integer = 10, fraction = 0)
    val phoneNumber: String,

    /**
     * Имя
     */
    @field:NotBlank
    @field:Size(min = 2, max = 32)
    val firstName: String,

    /**
     * Фамилия
     */
    @Nullable
    val lastName: String?,

    /**
     * Отчество
     */
    @Nullable
    val patronymic: String?
)
