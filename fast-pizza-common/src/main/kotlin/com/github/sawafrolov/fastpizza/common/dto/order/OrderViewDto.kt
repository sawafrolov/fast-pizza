package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaShortDto
import com.github.sawafrolov.fastpizza.common.serializers.BigDecimalSerializer
import com.github.sawafrolov.fastpizza.common.serializers.UuidSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO для отображения данных заказа
 */
@Serializable
data class OrderViewDto(

    /**
     * UUID
     */
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID,

    /**
     * Пользователь
     */
    val customer: CustomerShortDto,

    /**
     * Корзина
     */
    val cast: List<PizzaShortDto>,

    /**
     * Адрес доставки
     */
    val address: String,

    /**
     * Суммарный вес в граммах
     */
    val totalWeight: Int,

    /**
     * Суммарная стоимость в рублях
     */
    @Serializable(with = BigDecimalSerializer::class)
    val totalPrice: BigDecimal,

    /**
     * Статус выполнения заказа
     */
    val status: OrderStatus
)
