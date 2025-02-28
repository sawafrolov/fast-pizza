package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.api.v1.dto.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.models.Pizza
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.UUID

class PizzaMapperTest {

    private val pizzaMapper = PizzaMapperImpl()

    @Test
    @DisplayName("Test map pizza create DTO to pizza model")
    fun testMapToModel() {
        val pizzaCreateDto = PizzaCreateDto(
            name = "Pizza",
            description = "Pizza Description",
            weight = 345,
            price = 299.00,
            ingredients = listOf("Cheese", "Tomatoes")
        )
        val pizza = pizzaMapper.mapToModel(pizzaCreateDto)
        assertEquals(pizzaCreateDto.name, pizza.name)
        assertEquals(pizzaCreateDto.description, pizza.description)
        assertEquals(pizzaCreateDto.weight, pizza.weight)
        assertEquals(pizzaCreateDto.price, pizza.price.toDouble())
        assertEquals(2, pizza.ingredients.size)
        assertTrue("Cheese" in pizza.ingredients)
        assertTrue("Tomatoes" in pizza.ingredients)
    }

    @Test
    @DisplayName("Test map pizza model to pizza view DTO")
    fun testMapToDto() {
        val uuid = UUID.randomUUID()
        val pizza = Pizza(
            uuid = uuid,
            name = "Pizza",
            description = "Pizza Description",
            weight = 345,
            price = BigDecimal(299.00),
            ingredients = listOf("Cheese", "Tomatoes")
        )
        val pizzaViewDto = pizzaMapper.mapToDto(pizza)
        assertEquals(uuid, pizzaViewDto.uuid)
        assertEquals(pizza.name, pizzaViewDto.name)
        assertEquals(pizza.description, pizzaViewDto.description)
        assertEquals(pizza.weight, pizzaViewDto.weight)
        assertEquals(pizza.price.toDouble(), pizzaViewDto.price)
        assertEquals(2, pizzaViewDto.ingredients.size)
        assertTrue("Cheese" in pizzaViewDto.ingredients)
        assertTrue("Tomatoes" in pizzaViewDto.ingredients)
    }

    @Test
    @DisplayName("Test map pizza create DTO to pizza view DTO")
    fun testBothMappings() {
        val pizzaCreateDto = PizzaCreateDto(
            name = "Pizza",
            description = "Pizza Description",
            weight = 345,
            price = 299.00,
            ingredients = listOf("Cheese", "Tomatoes")
        )
        val pizza = pizzaMapper.mapToModel(pizzaCreateDto)
        val pizzaViewDto = pizzaMapper.mapToDto(pizza)
        assertEquals(pizzaCreateDto.name, pizzaViewDto.name)
        assertEquals(pizzaCreateDto.description, pizzaViewDto.description)
        assertEquals(pizzaCreateDto.weight, pizzaViewDto.weight)
        assertEquals(pizzaCreateDto.price, pizzaViewDto.price)
        assertEquals(2, pizzaViewDto.ingredients.size)
        assertTrue("Cheese" in pizzaViewDto.ingredients)
        assertTrue("Tomatoes" in pizzaViewDto.ingredients)
    }
}
