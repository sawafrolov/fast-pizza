package com.github.sawafrolov.fastpizza.orders.services

import com.github.sawafrolov.fastpizza.common.dto.order.OrderChangeStatusDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderCreateDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.util.test.correctOrderViewDto
import io.ktor.server.plugins.*
import java.util.UUID

class FakeOrderService: OrderService {

    override fun create(orderCreateDto: OrderCreateDto): OrderViewDto =
        correctOrderViewDto

    override fun findAll(): List<OrderViewDto> =
        listOf()

    override fun findById(id: UUID): OrderViewDto {
        if (id != correctOrderViewDto.uuid) {
            throw NotFoundException("Order $id not found")
        }
        return correctOrderViewDto
    }

    override fun updateStatus(id: UUID, orderChangeStatusDto: OrderChangeStatusDto): OrderViewDto =
        findById(id).copy(status = orderChangeStatusDto.status)

    override fun delete(id: UUID) {}
}
