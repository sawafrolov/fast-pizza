package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.BigDecimalSerializer
import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO пиццы
 */
@Serializable
data class PizzaDto(
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID?,
    val name: String,
    val description: String?,
    val weight: Int,
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,
    val ingredients: List<String>
)
