package com.github.sawafrolov.fastpizza.pizza.controller

import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaUpdateDto
import com.github.sawafrolov.fastpizza.pizza.services.PizzaService
import com.github.sawafrolov.fastpizza.starter.util.getPathParamId
import com.github.sawafrolov.fastpizza.starter.util.validateDto
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import jakarta.validation.Validator
import org.koin.java.KoinJavaComponent.inject

private val validator: Validator by inject(Validator::class.java)

private val pizzaService: PizzaService by inject(PizzaService::class.java)

fun Route.createPizza() {
    post {
        val pizzaCreateDto = call.receive<PizzaCreateDto>()
        validator.validateDto(pizzaCreateDto, "Pizza create DTO invalid")
        val result = pizzaService.create(pizzaCreateDto)
        call.response.status(HttpStatusCode.Created)
        call.respond(result, null)
    }
}

fun Route.findAllPizzas() {
    get {
        val result = pizzaService.findAll()
        call.response.status(HttpStatusCode.OK)
        call.respond(result, null)
    }
}

fun Route.findPizzaById() {
    get("/{id}") {
        val id = call.getPathParamId()
        val result = pizzaService.findById(id)
        call.response.status(HttpStatusCode.OK)
        call.respond(result, null)
    }
}

fun Route.updatePizza() {
    put("/{id}") {
        val id = call.getPathParamId()
        val pizzaUpdateDto = call.receive<PizzaUpdateDto>()
        validator.validateDto(pizzaUpdateDto, "Pizza update DTO invalid")
        val result = pizzaService.update(id, pizzaUpdateDto)
        call.response.status(HttpStatusCode.Created)
        call.respond(result, null)
    }
}

fun Route.deletePizza() {
    delete("/{id}") {
        val id = call.getPathParamId()
        pizzaService.delete(id)
        call.response.status(HttpStatusCode.NoContent)
    }
}
