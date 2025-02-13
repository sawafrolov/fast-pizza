package com.github.sawafrolov.fastpizza.orders.controllers

import com.github.sawafrolov.fastpizza.common.dto.order.OrderChangeStatusDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderCreateDto
import com.github.sawafrolov.fastpizza.orders.services.OrderService
import com.github.sawafrolov.fastpizza.starter.exceptions.ForbiddenException
import com.github.sawafrolov.fastpizza.starter.util.getPathParamId
import com.github.sawafrolov.fastpizza.starter.util.getUserId
import com.github.sawafrolov.fastpizza.starter.util.validateDto
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jakarta.validation.Validator
import org.koin.java.KoinJavaComponent.inject

private val validator: Validator by inject(Validator::class.java)

private val orderService: OrderService by inject(OrderService::class.java)

fun Route.createOrder() {
    post {
        val orderCreateDto = call.receive<OrderCreateDto>()
        if (orderCreateDto.customerId != call.getUserId()) {
            throw ForbiddenException("Forbidden")
        }
        validator.validateDto(orderCreateDto, "Order create DTO invalid")
        val result = orderService.create(orderCreateDto)
        call.response.status(HttpStatusCode.Created)
        call.respond(result, null)
    }
}

fun Route.findAllOrders() {
    get {
        val result = orderService.findAll()
        call.response.status(HttpStatusCode.OK)
        call.respond(result, null)
    }
}

fun Route.findOrderById() {
    get("/{id}") {
        val orderId = call.getPathParamId()
        val result = orderService.findById(orderId)
        call.response.status(HttpStatusCode.OK)
        call.respond(result, null)
    }
}

fun Route.updateOrderStatus() {
    put("/{id}/status") {
        val orderId = call.getPathParamId()
        val orderChangeStatusDto = call.receive<OrderChangeStatusDto>()
        val result = orderService.updateStatus(orderId, orderChangeStatusDto)
        call.response.status(HttpStatusCode.OK)
        call.respond(result, null)
    }
}

fun Route.deleteOrder() {
    delete("/{id}") {
        val orderId = call.getPathParamId()
        orderService.delete(orderId)
        call.response.status(HttpStatusCode.NoContent)
        call.respondText("Order deleted successfully")
    }
}
