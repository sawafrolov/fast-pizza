package com.github.sawafrolov.fastpizza.common.dto

import java.math.BigDecimal

data class PizzaSearchFilter(
    var nameContains: String,
    var descriptionContains: String,
    var weightFrom: Int,
    var weightTo: Int,
    var priceFrom: BigDecimal,
    var priceTo: BigDecimal,
    var ingredientsContains: List<String>
)
