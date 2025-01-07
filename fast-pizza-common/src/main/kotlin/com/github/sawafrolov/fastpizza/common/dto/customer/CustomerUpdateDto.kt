package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.serializers.UuidSerializer
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable
import java.util.UUID

/**
 * DTO редактирования данных пользователя
 */
@Serializable
data class CustomerUpdateDto(

    /**
     * UUID
     */
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID,

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
