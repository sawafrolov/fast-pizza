package com.github.sawafrolov.fastpizza.customers.services

import com.github.sawafrolov.fastpizza.common.dto.customer.*
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.util.test.fullCustomerViewDto
import java.util.UUID

/**
 * Фейковая реализация сервиса пользователей
 */
class FakeCustomerService: CustomerService {

    override fun findById(id: UUID): CustomerViewDto? =
        if (id == fullCustomerViewDto.uuid) fullCustomerViewDto else null

    override fun findAllOrders(id: UUID): List<OrderViewDto> =
        listOf()

    override fun update(id: UUID, customerUpdateDto: CustomerUpdateDto) {}

    override fun delete(id: UUID) {}
}
