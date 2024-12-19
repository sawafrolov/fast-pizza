package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.util.UUID

data class OrderDto(
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID?,
    val customer: CustomerDto,
    val cast: List<OrderItemDto>,
    val totalWeight: Int,
    val totalPrice: BigDecimal
)
