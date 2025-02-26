package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.api.v1.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.api.v1.dto.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.models.Pizza
import java.math.BigDecimal
import java.util.UUID

class PizzaMapperImpl: PizzaMapper {

    override fun mapToModel(pizzaCreateDto: PizzaCreateDto): Pizza =
        Pizza(
            uuid = UUID.randomUUID(),
            name = pizzaCreateDto.name,
            description = pizzaCreateDto.description,
            weight = pizzaCreateDto.weight,
            price = BigDecimal(pizzaCreateDto.price),
            ingredients = pizzaCreateDto.ingredients
        )

    override fun mapToDto(pizza: Pizza): PizzaViewDto =
        PizzaViewDto(
            uuid = pizza.uuid,
            name = pizza.name,
            description = pizza.description,
            weight = pizza.weight,
            price = pizza.price.toDouble(),
            ingredients = pizza.ingredients
        )
}
