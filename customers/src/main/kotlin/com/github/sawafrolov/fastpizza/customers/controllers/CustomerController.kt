package com.github.sawafrolov.fastpizza.customers.controllers

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerUpdateDto
import com.github.sawafrolov.fastpizza.customers.services.CustomerService
import com.github.sawafrolov.fastpizza.starter.util.*
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jakarta.validation.Validator
import org.koin.java.KoinJavaComponent.inject

private val validator: Validator by inject(Validator::class.java)

private val customerService: CustomerService by inject(CustomerService::class.java)

fun Route.findCustomerById() {
    get("/{id}") {
        call.checkPathParamId()
        val customerId = call.getPathParamId()
        val result = customerService.findById(customerId)
        call.respond(HttpStatusCode.OK, result)
    }
}

fun Route.updateCustomer() {
    put("/{id}") {
        call.checkPathParamId()
        val customerId = call.getPathParamId()
        val customerUpdateDto = call.receive<CustomerUpdateDto>()
        validator.validateDto(customerUpdateDto, "Customer update DTO invalid")
        val result = customerService.update(customerId, customerUpdateDto)
        call.respond(HttpStatusCode.OK, result)
    }
}

fun Route.deleteCustomer() {
    delete("/{id}") {
        call.checkPathParamId()
        val customerId = call.getPathParamId()
        customerService.delete(customerId)
        call.response.status(HttpStatusCode.NoContent)
    }
}
