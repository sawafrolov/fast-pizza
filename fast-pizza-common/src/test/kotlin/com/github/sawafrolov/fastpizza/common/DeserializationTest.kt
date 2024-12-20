package com.github.sawafrolov.fastpizza.common

import com.github.sawafrolov.fastpizza.common.dto.PizzaDto
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DeserializationTest {

    @Test
    @DisplayName("Test correct pizza deserialization")
    fun testCorrectPizza() {
        val data = """
            {
                "uuid": "8f5581c2-5311-450c-9043-a0f03f0a3142",
                "name": "Test Pizza",
                "description": "Test Pizza Description",
                "weight": 345,
                "price": "600.00",
                "ingredients": ["Cheese", "Tomatoes"]
            }
        """.trimIndent()
        val pizza = Json.decodeFromString<PizzaDto>(data)
        assertEquals(2, pizza.ingredients.size)
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Test
    @DisplayName("Test incorrect pizza deserialization")
    fun testIncorrectPizza() {
        val data = """
            {
                "uuid": "8f5581c2-5311-450c-9043-a0f03f0a3142",
                "description": "Test Pizza Description",
                "weight": 345,
                "price": "600.00",
                "ingredients": ["Cheese", "Tomatoes"]
            }
        """.trimIndent()
        assertThrows(MissingFieldException::class.java) {
            Json.decodeFromString<PizzaDto>(data)
        }
    }
}
