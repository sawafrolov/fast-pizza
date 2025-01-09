package com.github.sawafrolov.fastpizza.orders.mappers

import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaShortDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity

interface PizzaMapper {

    fun mapToEntity(pizzaCreateDto: PizzaCreateDto): PizzaEntity

    fun mapToShortDto(entity: PizzaEntity): PizzaShortDto

    fun mapToViewDto(entity: PizzaEntity): PizzaViewDto
}
