package com.github.sawafrolov.fastpizza.common.dto

import java.math.BigDecimal
import java.util.UUID

data class PizzaUpdateDto(
    var uuid: UUID,
    val description: String?,
    val weight: Int,
    val price: BigDecimal,
    val ingredients: List<String>
)
