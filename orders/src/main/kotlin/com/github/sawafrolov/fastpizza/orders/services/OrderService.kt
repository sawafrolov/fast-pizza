package com.github.sawafrolov.fastpizza.orders.services

import com.github.sawafrolov.fastpizza.common.dto.order.OrderChangeStatusDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderCreateDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import java.util.UUID

interface OrderService {

    fun create(orderCreateDto: OrderCreateDto): OrderViewDto

    fun findAll(): List<OrderViewDto>

    fun findById(id: UUID): OrderViewDto

    fun updateStatus(id: UUID, orderChangeStatusDto: OrderChangeStatusDto): OrderViewDto

    fun delete(id: UUID)
}
