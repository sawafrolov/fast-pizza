package com.github.sawafrolov.fastpizza.common.dto.order

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
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
    val cast: List<@Contextual UUID>,

    /**
     * Адрес доставки
     */
    val address: String
)
