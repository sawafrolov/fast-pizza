package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity

interface CustomerMapper {

    fun mapToShortDto(entity: CustomerEntity): CustomerShortDto

    fun mapToViewDto(entity: CustomerEntity): CustomerViewDto
}
