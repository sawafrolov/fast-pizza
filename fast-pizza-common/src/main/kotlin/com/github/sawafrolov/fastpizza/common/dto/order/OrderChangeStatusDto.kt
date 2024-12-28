package com.github.sawafrolov.fastpizza.common.dto.order

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class OrderChangeStatusDto(

    /**
     * UUID заказа
     */
    @Contextual
    val uuid: UUID,

    /**
     * Новый статус
     */
    val status: OrderStatus
)
