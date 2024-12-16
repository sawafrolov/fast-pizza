package com.github.sawafrolov.fastpizza.common.dto

import java.math.BigDecimal
import java.util.UUID

/**
 * DTO пиццы
 */
data class PizzaDto(
    val uuid: UUID?,
    val name: String,
    val description: String?,
    val weight: Int,
    val price: BigDecimal,
    val ingredients: List<String>
)
