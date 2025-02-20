package com.github.sawafrolov.fastpizza.common.dto

import java.math.BigDecimal
import java.util.UUID

data class PizzaViewDto(
    var uuid: UUID,
    var name: String,
    var description: String?,
    var weight: Int,
    var price: BigDecimal,
    var ingredients: List<String>
)
