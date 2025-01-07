package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.serializers.UuidSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class OrderChangeStatusDto(

    /**
     * UUID заказа
     */
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID,

    /**
     * Новый статус
     */
    val status: OrderStatus
)
