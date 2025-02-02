package com.github.sawafrolov.fastpizza.customers.services

import com.github.sawafrolov.fastpizza.common.dto.customer.*
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import java.util.UUID

interface CustomerService {

    fun register(customerRegistrationDto: CustomerRegistrationDto): CustomerViewDto

    fun login(customerLoginDto: CustomerLoginDto): CustomerViewDto

    fun logout()

    fun changePassword(customerChangePasswordDto: CustomerChangePasswordDto)

    fun findById(id: UUID): CustomerViewDto?

    fun findAllOrders(id: UUID): List<OrderViewDto>

    fun update(id: UUID, customerUpdateDto: CustomerUpdateDto)

    fun delete(id: UUID)
}
