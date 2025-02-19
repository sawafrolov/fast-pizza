package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.test.correctPizzaUpdateDto
import com.github.sawafrolov.fastpizza.common.util.test.fullPizzaUpdateDto
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
 * Тестирование десериализации PizzaUpdateDto
 */
class PizzaUpdateDtoDeserializationTest {

    private val dtoType = "update"

    private val validator = validator()

    @Test
    @DisplayName("Pizza update DTO deserialization test - correct")
    fun testCorrectPizzaUpdateDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = readJson(dtoType, filename)
        val actual = fromJson<PizzaUpdateDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(correctPizzaUpdateDto, actual)
    }

    @Test
    @DisplayName("Pizza update DTO deserialization test - full")
    fun testFullPizzaUpdateDtoDeserialization() {
        val filename = "full.json"
        val actualJson = readJson(dtoType, filename)
        val actual = fromJson<PizzaUpdateDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(fullPizzaUpdateDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Pizza update DTO deserialization test - incorrect")
    fun testIncorrectPizzaUpdateDtoDeserialization() {
        val filename = "incorrect.json"
        val json = readJson(dtoType, filename)
        assertThrows<MissingFieldException> {
            fromJson<PizzaUpdateDto>(json)
        }
    }

    @Test
    @DisplayName("Pizza update DTO deserialization test - invalid")
    fun testInvalidPizzaUpdateDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = readJson(dtoType, filename)
        val actual = fromJson<PizzaUpdateDto>(actualJson)
        assertFalse(validator.isValid(actual))
    }
}
