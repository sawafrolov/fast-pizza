package com.github.sawafrolov.fastpizza.orders.mappers.impl

import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaShortDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity
import com.github.sawafrolov.fastpizza.orders.mappers.PizzaMapper

class PizzaMapperImpl: PizzaMapper {

    override fun mapToEntity(pizzaCreateDto: PizzaCreateDto): PizzaEntity =
        PizzaEntity.new {
            name = pizzaCreateDto.name
            description = pizzaCreateDto.description
            weight = pizzaCreateDto.weight
            price = pizzaCreateDto.price
            ingredients = pizzaCreateDto.ingredients
        }


    override fun mapToShortDto(entity: PizzaEntity): PizzaShortDto =
        PizzaShortDto(entity.uuid.value, entity.name)

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
