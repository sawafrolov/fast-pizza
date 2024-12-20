package com.github.sawafrolov.fastpizza.common

import com.github.sawafrolov.fastpizza.common.dto.PizzaDto
import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.ObjectUtil
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
        val data = JsonUtil.readJson("correctPizza.json")
        val pizza = Json.decodeFromString<PizzaDto>(data)
        assertEquals(ObjectUtil.correctPizzaDto, pizza)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Test incorrect pizza deserialization")
    fun testIncorrectPizza() {
        val data = JsonUtil.readJson("incorrectPizza.json")
        assertThrows(MissingFieldException::class.java) {
            Json.decodeFromString<PizzaDto>(data)
        }
    }
}
