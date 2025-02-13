package com.github.sawafrolov.fastpizza.pizza.services

import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaUpdateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaViewDto
import java.util.UUID

interface PizzaService {

    fun create(pizzaCreateDto: PizzaCreateDto): PizzaViewDto

    fun findAll(): List<PizzaViewDto>

    fun findById(id: UUID): PizzaViewDto

    fun update(id: UUID, pizzaUpdateDto: PizzaUpdateDto): PizzaViewDto

    fun delete(id: UUID)
}
