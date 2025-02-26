package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.api.v1.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.api.v1.dto.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.models.Pizza

interface PizzaMapper {

    fun mapToModel(pizzaCreateDto: PizzaCreateDto): Pizza

    fun mapToDto(pizza: Pizza): PizzaViewDto
}
