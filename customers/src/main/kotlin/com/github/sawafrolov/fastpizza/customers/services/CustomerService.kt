package com.github.sawafrolov.fastpizza.customers.services

import com.github.sawafrolov.fastpizza.common.dto.customer.*
import java.util.UUID

interface CustomerService {

    fun findById(id: UUID): CustomerViewDto

    fun update(id: UUID, customerUpdateDto: CustomerUpdateDto): CustomerViewDto

    fun delete(id: UUID)
}
