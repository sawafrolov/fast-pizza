package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import jakarta.validation.constraints.Digits
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.util.UUID
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable

/**
 * DTO отображения данных пользователя
 */
@Serializable
data class CustomerViewDto(

    /**
     * UUID
     */
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID,

    /**
     * Адрес электронной почты
     */
    @field:Email
    @field:NotBlank
    val email: String,

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
    val patronymic: String?,

    /**
     * Список адресов
     */
    @Nullable
    val addresses: List<String>,

    /**
     * Список заказов
     */
    @Nullable
    val orders: List<OrderViewDto>
)
