package com.github.sawafrolov.fastpizza.customers.controllers

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerUpdateDto
import com.github.sawafrolov.fastpizza.customers.services.CustomerService
import com.github.sawafrolov.fastpizza.starter.util.checkPathParamId
import com.github.sawafrolov.fastpizza.starter.util.getUserId
import com.github.sawafrolov.fastpizza.starter.util.validateDto
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import jakarta.validation.Validator
import org.koin.java.KoinJavaComponent.inject

private val validator: Validator by inject(Validator::class.java)

private val customerService: CustomerService by inject(CustomerService::class.java)

fun Route.findCustomerById() {
    get("/{id}") {
        call.checkPathParamId()
        val userId = call.getUserId()
        val result = customerService.findById(userId)
        call.response.status(HttpStatusCode.OK)
        call.respond(result, typeInfo = null)
    }
}

fun Route.updateCustomer() {
    put("/{id}") {
        call.checkPathParamId()
        val userId = call.getUserId()
        val customerUpdateDto = call.receive<CustomerUpdateDto>()
        validator.validateDto(customerUpdateDto, "Customer update DTO invalid")
        val result = customerService.update(userId, customerUpdateDto)
        call.response.status(HttpStatusCode.OK)
        call.respond(result, typeInfo = null)
    }
}

fun Route.deleteCustomer() {
    delete("/{id}") {
        call.checkPathParamId()
        val userId = call.getUserId()
        customerService.delete(userId)
        call.response.status(HttpStatusCode.NoContent)
    }
}
