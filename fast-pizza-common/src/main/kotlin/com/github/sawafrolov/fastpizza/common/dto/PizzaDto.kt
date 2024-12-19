package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO пиццы
 */
data class PizzaDto(
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID?,
    val name: String,
    val description: String?,
    val weight: Int,
    val price: BigDecimal,
    val ingredients: List<String>
)
