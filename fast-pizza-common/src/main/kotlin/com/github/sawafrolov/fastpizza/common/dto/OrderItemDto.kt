package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

data class OrderItemDto(
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID?,
    val order: OrderDto,
    val pizza: PizzaDto,
    val quantity: Int
)
