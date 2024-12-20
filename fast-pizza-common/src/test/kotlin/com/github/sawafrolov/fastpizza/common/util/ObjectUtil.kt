package com.github.sawafrolov.fastpizza.common.util

import com.github.sawafrolov.fastpizza.common.dto.PizzaDto
import java.math.BigDecimal
import java.util.UUID

class ObjectUtil {

    companion object {
        val correctPizzaDto = PizzaDto(
            uuid = UUID.fromString("8f5581c2-5311-450c-9043-a0f03f0a3142"),
            name = "Test Pizza",
            description = "Test Pizza Description",
            weight = 345,
            price = BigDecimal("600.00"),
            ingredients = listOf("Cheese", "Tomatoes")
        )
    }
}
