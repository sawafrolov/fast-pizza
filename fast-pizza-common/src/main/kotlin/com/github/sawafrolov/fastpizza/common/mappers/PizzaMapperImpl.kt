package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.common.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity
import java.math.BigDecimal

class PizzaMapperImpl: PizzaMapper {

    override fun mapToEntity(pizzaCreateDto: PizzaCreateDto): PizzaEntity =
        PizzaEntity.new {
            name = pizzaCreateDto.name
            description = pizzaCreateDto.description
            weight = pizzaCreateDto.weight
            price = BigDecimal(pizzaCreateDto.price)
            ingredients = pizzaCreateDto.ingredients
        }

    override fun mapToDto(pizzaEntity: PizzaEntity): PizzaViewDto =
        PizzaViewDto(
            uuid = pizzaEntity.uuid.value,
            name = pizzaEntity.name,
            description = pizzaEntity.description,
            weight = pizzaEntity.weight,
            price = pizzaEntity.price.toDouble(),
            ingredients = pizzaEntity.ingredients
        )
}
