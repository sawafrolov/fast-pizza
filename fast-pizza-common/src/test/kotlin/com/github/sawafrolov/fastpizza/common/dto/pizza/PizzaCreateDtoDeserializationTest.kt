package com.github.sawafrolov.fastpizza.common.dto.pizza

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.test.correctPizzaCreateDto
import com.github.sawafrolov.fastpizza.common.util.test.fullPizzaCreateDto
import com.github.sawafrolov.fastpizza.common.util.validation.isValid
import com.github.sawafrolov.fastpizza.common.util.validation.validator
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Тестирование десериализации PizzaCreateDto
 */
class PizzaCreateDtoDeserializationTest {

    private val entityName = "pizza"

    private val dtoType = "create"

    private val validator = validator()

    @Test
    @DisplayName("Pizza create DTO deserialization test - correct")
    fun testCorrectPizzaCreateDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<PizzaCreateDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(correctPizzaCreateDto, actual)
    }

    @Test
    @DisplayName("Pizza create DTO deserialization test - full")
    fun testFullPizzaCreateDtoDeserialization() {
        val filename = "full.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<PizzaCreateDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(fullPizzaCreateDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Pizza create DTO deserialization test - incorrect")
    fun testIncorrectPizzaCreateDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<PizzaCreateDto>(json)
        }
    }

    @Test
    @DisplayName("Pizza create DTO deserialization test - invalid")
    fun testInvalidPizzaCreateDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<PizzaCreateDto>(actualJson)
        assertFalse(validator.isValid(actual))
    }
}
