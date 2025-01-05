package com.github.sawafrolov.fastpizza.common.dto.pizza

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.ObjectUtil
import com.github.sawafrolov.fastpizza.common.util.ValidationUtil
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

    private val entityName = "pizza"

    private val dtoType = "update"

    @Test
    @DisplayName("Pizza update DTO deserialization test - correct")
    fun testCorrectPizzaCreateDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<PizzaUpdateDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.correctPizzaUpdateDto, actual)
    }

    @Test
    @DisplayName("Pizza update DTO deserialization test - full")
    fun testFullPizzaCreateDtoDeserialization() {
        val filename = "full.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<PizzaUpdateDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.fullPizzaUpdateDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Pizza update DTO deserialization test - incorrect")
    fun testIncorrectPizzaCreateDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<PizzaUpdateDto>(json)
        }
    }

    @Test
    @DisplayName("Pizza update DTO deserialization test - invalid")
    fun testInvalidPizzaCreateDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<PizzaUpdateDto>(actualJson)
        assertFalse(ValidationUtil.isValid(actual))
    }
}
