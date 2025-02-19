package com.github.sawafrolov.fastpizza.common.util.test

import com.github.sawafrolov.fastpizza.common.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaShortDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaUpdateDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaViewDto
import java.math.BigDecimal
import java.util.UUID

private val uuid = UUID.fromString("8f5581c2-5311-450c-9043-a0f03f0a3142")
private const val testPizza = "Test Pizza"
private const val testPizzaDescription = "Test Pizza Description"

private const val weight = 345
private val price = BigDecimal("600.00")
private val ingredients = listOf("Cheese", "Tomatoes")

val correctPizzaCreateDto = PizzaCreateDto(
    name = testPizza,
    description = null,
    weight = weight,
    price = price,
    ingredients = ingredients
)

val fullPizzaCreateDto = PizzaCreateDto(
    name = testPizza,
    description = testPizzaDescription,
    weight = weight,
    price = price,
    ingredients = ingredients
)

val correctPizzaShortDto = PizzaShortDto(
    uuid = uuid,
    name = testPizza
)

val correctPizzaUpdateDto = PizzaUpdateDto(
    uuid = uuid,
    description = null,
    weight = weight,
    price = price,
    ingredients = ingredients
)

val fullPizzaUpdateDto = PizzaUpdateDto(
    uuid = uuid,
    description = testPizzaDescription,
    weight = weight,
    price = price,
    ingredients = ingredients
)

val correctPizzaViewDto = PizzaViewDto(
    uuid = uuid,
    name = testPizza,
    description = null,
    weight = weight,
    price = price,
    ingredients = ingredients
)

val fullPizzaViewDto = PizzaViewDto(
    uuid = uuid,
    name = testPizza,
    description = testPizzaDescription,
    weight = weight,
    price = price,
    ingredients = ingredients
)
