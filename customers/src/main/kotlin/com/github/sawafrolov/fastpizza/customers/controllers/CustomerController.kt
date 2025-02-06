package com.github.sawafrolov.fastpizza.customers.controllers

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerUpdateDto
import com.github.sawafrolov.fastpizza.customers.services.CustomerService
import com.github.sawafrolov.fastpizza.starter.util.getUserId
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

private val customerService: CustomerService by inject(CustomerService::class.java)

fun Route.getCustomer() {
    get {
        val userId = getUserId(call)
        val result = customerService.findById(userId)
        call.response.status(HttpStatusCode.OK)
        call.respond(result, typeInfo = null)
    }
}

fun Route.updateCustomer() {
    put {
        val userId = getUserId(call)
        val customerUpdateDto = call.receive<CustomerUpdateDto>()
        val result = customerService.update(userId, customerUpdateDto)
        call.response.status(HttpStatusCode.OK)
        call.respond(result, typeInfo = null)
    }
}

fun Route.deleteCustomer() {
    delete {
        val userId = getUserId(call)
        customerService.delete(userId)
        call.response.status(HttpStatusCode.NoContent)
    }
}
