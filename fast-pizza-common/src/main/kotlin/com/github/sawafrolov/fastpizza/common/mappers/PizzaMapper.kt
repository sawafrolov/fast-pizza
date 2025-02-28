package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.common.models.Pizza
import com.github.sawafrolov.fastpizza.fastpizzaapi.api.v1.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.fastpizzaapi.api.v1.dto.PizzaViewDto

interface PizzaMapper {

    fun mapToModel(pizzaCreateDto: PizzaCreateDto): Pizza

    fun mapToDto(pizza: Pizza): PizzaViewDto
}
