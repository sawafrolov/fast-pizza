package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.util.serializers.BigDecimalSerializer
import com.github.sawafrolov.fastpizza.common.util.serializers.UuidSerializer
import jakarta.validation.constraints.*
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
    @Serializable(with = UuidSerializer::class)
    val customerId: UUID,

    /**
     * Корзина
     */
    @field:NotEmpty
    val cast: List<@Serializable(with = UuidSerializer::class) UUID>,

    /**
     * Адрес доставки
     */
    @field:NotBlank
    @field:Size(min = 10, max = 100)
    val address: String,

    /**
     * Суммарный вес в граммах
     */
    @field:Positive
    val totalWeight: Int,

    /**
     * Суммарная стоимость в рублях
     */
    @field:Positive
    @Serializable(with = BigDecimalSerializer::class)
    val totalPrice: BigDecimal
)
