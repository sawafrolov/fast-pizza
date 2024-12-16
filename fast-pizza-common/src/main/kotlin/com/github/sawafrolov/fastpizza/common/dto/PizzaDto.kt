package com.github.sawafrolov.fastpizza.common.dto

import java.util.UUID

/**
 * DTO пиццы
 */
data class PizzaDto(
    val uuid: UUID?,
    val name: String,
    val description: String?,
    val weight: Int,
    val ingredients: List<String>
)
