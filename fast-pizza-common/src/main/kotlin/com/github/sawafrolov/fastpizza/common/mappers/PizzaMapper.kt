package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.common.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaShortDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity

interface PizzaMapper {

    fun mapToEntity(pizzaCreateDto: PizzaCreateDto): PizzaEntity

    fun mapToShortDto(entity: PizzaEntity): PizzaShortDto

    fun mapToViewDto(entity: PizzaEntity): PizzaViewDto
}
