package com.github.sawafrolov.fastpizza.common.dto

import java.math.BigDecimal

data class PizzaCreateDto(
    var name: String,
    var description: String?,
    var weight: Int,
    var price: BigDecimal,
    var ingredients: List<String>
)
