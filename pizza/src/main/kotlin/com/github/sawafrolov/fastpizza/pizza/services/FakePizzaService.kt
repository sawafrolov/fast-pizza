package com.github.sawafrolov.fastpizza.pizza.services

import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaUpdateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.util.test.fullPizzaViewDto
import io.ktor.server.plugins.*
import java.util.UUID

class FakePizzaService: PizzaService {

    override fun create(pizzaCreateDto: PizzaCreateDto): PizzaViewDto =
        fullPizzaViewDto

    override fun findAll(): List<PizzaViewDto> =
        listOf()

    override fun findById(id: UUID): PizzaViewDto {
        if (id != fullPizzaViewDto.uuid) {
            throw NotFoundException("Pizza $id not found")
        }
        return fullPizzaViewDto
    }

    override fun update(id: UUID, pizzaUpdateDto: PizzaUpdateDto): PizzaViewDto =
        findById(id)

    override fun delete(id: UUID) {}
}
