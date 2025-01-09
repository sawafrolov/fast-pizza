package com.github.sawafrolov.fastpizza.orders.mappers.impl

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerRegistrationDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity
import com.github.sawafrolov.fastpizza.orders.mappers.CustomerMapper

class CustomerMapperImpl: CustomerMapper {

    override fun mapToEntity(customerRegistrationDto: CustomerRegistrationDto): CustomerEntity =
        CustomerEntity.new {
            email = customerRegistrationDto.email
            password = customerRegistrationDto.password
            phoneNumber = customerRegistrationDto.phoneNumber
            firstName = customerRegistrationDto.firstName
            lastName = customerRegistrationDto.lastName
            patronymic = customerRegistrationDto.patronymic
        }

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
