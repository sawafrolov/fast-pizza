package com.github.sawafrolov.fastpizza.customers.mappers

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity

class CustomerMapperImpl: CustomerMapper {

    override fun mapToShortDto(entity: CustomerEntity): CustomerShortDto =
        CustomerShortDto(
            uuid = entity.uuid.value,
            email = entity.email
        )

    override fun mapToViewDto(entity: CustomerEntity): CustomerViewDto =
        CustomerViewDto(
            uuid = entity.uuid.value,
            email = entity.email,
            phoneNumber = entity.phoneNumber,
            firstName = entity.firstName,
            lastName = entity.lastName,
            patronymic = entity.patronymic,
            addresses = entity.addresses
        )
}
