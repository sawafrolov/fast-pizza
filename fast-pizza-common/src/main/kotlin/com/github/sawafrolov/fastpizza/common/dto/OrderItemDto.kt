package com.github.sawafrolov.fastpizza.common.dto

import java.util.UUID

data class OrderItemDto(
    val uuid: UUID?,
    val order: OrderDto,
    val pizza: PizzaDto,
    val quantity: Int
)
