package com.github.sawafrolov.fastpizza.customers.services

import com.github.sawafrolov.fastpizza.common.dto.customer.*
import com.github.sawafrolov.fastpizza.common.util.test.fullCustomerViewDto
import io.ktor.server.plugins.*
import java.util.UUID

/**
 * Фейковая реализация сервиса пользователей
 */
class FakeCustomerService: CustomerService {

    override fun findById(id: UUID): CustomerViewDto =
        if (id == fullCustomerViewDto.uuid) fullCustomerViewDto
            else throw NotFoundException("Customer $id not found")

    override fun update(id: UUID, customerUpdateDto: CustomerUpdateDto): CustomerViewDto =
        findById(id)

    override fun delete(id: UUID) {}
}
