package com.github.sawafrolov.fastpizza.orders.mappers

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerRegistrationDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity

interface CustomerMapper {

    fun mapToEntity(customerRegistrationDto: CustomerRegistrationDto): CustomerEntity

    fun mapToShortDto(entity: CustomerEntity): CustomerShortDto

    fun mapToViewDto(entity: CustomerEntity): CustomerViewDto
}
