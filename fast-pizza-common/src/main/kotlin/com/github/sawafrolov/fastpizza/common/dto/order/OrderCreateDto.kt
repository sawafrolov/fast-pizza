package com.github.sawafrolov.fastpizza.common.dto.order

import jakarta.validation.constraints.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO для создания заказа
 */
@Serializable
data class OrderCreateDto(

    /**
     * UUID пользователя
     */
    @Contextual
    val customerId: UUID,

    /**
     * Корзина
     */
    @field:NotEmpty
    val cast: List<@Contextual UUID>,

    /**
     * Адрес доставки
     */
    @field:NotBlank
    @field:Size(min = 10, max = 50)
    val address: String,

    /**
     * Суммарный вес в граммах
     */
    @field:Positive
    val totalWeight: Int,

    /**
     * Суммарная стоимость в рублях
     */
    @Contextual
    @field:Positive
    val totalPrice: BigDecimal
)
