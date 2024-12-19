package com.github.sawafrolov.fastpizza.common.dto

import java.math.BigDecimal
import java.util.UUID

data class OrderDto(
    val uuid: UUID?,
    val customer: CustomerDto,
    val cast: List<OrderItemDto>,
    val totalWeight: Int,
    val totalPrice: BigDecimal
)