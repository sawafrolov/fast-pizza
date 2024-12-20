package com.github.sawafrolov.fastpizza.common.util

import com.github.sawafrolov.fastpizza.common.dto.CustomerDto
import com.github.sawafrolov.fastpizza.common.dto.PizzaDto
import java.math.BigDecimal
import java.util.UUID

class ObjectUtil {

    companion object {

        private val uuid = UUID.fromString("8f5581c2-5311-450c-9043-a0f03f0a3142")

        val correctPizzaDto = PizzaDto(
            uuid = uuid,
            name = "Test Pizza",
            description = "Test Pizza Description",
            weight = 345,
            price = BigDecimal("600.00"),
            ingredients = listOf("Cheese", "Tomatoes")
        )

        val correctCustomerDto = CustomerDto(
            uuid = uuid,
            email = "test@test.com",
            password = "password",
            phoneNumber = "+7 (123) 456-78-90",
            firstName = "Test",
            lastName = "Test",
            patronymic = "Patronymic",
            addresses = listOf("TestAddress1", "TestAddress2")
        )
    }
}
