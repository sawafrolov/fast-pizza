package com.github.sawafrolov.fastpizza.common.models

import java.math.BigDecimal
import java.util.UUID

/**
 * Сущность пиццы
 */
data class Pizza(
    val uuid: UUID,
    val name: String,
    val description: String?,
    val weight: Int,
    val price: BigDecimal,
    val ingredients: List<String>
)
