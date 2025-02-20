package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.common.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity

class PizzaMapperImpl: PizzaMapper {

    override fun mapToEntity(pizzaCreateDto: PizzaCreateDto): PizzaEntity =
        PizzaEntity.new {
            name = pizzaCreateDto.name
            description = pizzaCreateDto.description
            weight = pizzaCreateDto.weight
            price = pizzaCreateDto.price
            ingredients = pizzaCreateDto.ingredients
        }

    override fun mapToViewDto(entity: PizzaEntity): PizzaViewDto =
        PizzaViewDto(
            entity.uuid.value,
            entity.name,
            entity.description,
            entity.weight,
            entity.price,
            entity.ingredients
        )
}
