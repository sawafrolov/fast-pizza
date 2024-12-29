package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaShortDto
import kotlinx.serialization.Contextual
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
    @Contextual
    val uuid: UUID,

    /**
     * Пользователь
     */
    @Contextual
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
    @Contextual
    val totalPrice: BigDecimal,

    /**
     * Статус выполнения заказа
     */
    val status: OrderStatus
)
