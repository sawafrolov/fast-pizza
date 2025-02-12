package com.github.sawafrolov.fastpizza.common.mappers.impl

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity
import com.github.sawafrolov.fastpizza.common.mappers.CustomerMapper
import java.util.UUID

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
            addresses = entity.addresses,
            pizzas = mapPizzas(entity.pizzas)
        )

    private fun mapPizzas(pizzas: List<UUID>): Map<String, Int> {
        val result = mutableMapOf<String, Int>()
        pizzas.forEach {
            result[it.toString()] = result.getOrDefault(it.toString(), 0) + 1
        }
        return result
    }
}
