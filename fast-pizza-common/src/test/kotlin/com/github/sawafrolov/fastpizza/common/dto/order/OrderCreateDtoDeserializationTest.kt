package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.test.correctOrderCreateDto
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
 * Тестирование десериализации OrderCreateDto
 */
class OrderCreateDtoDeserializationTest {

    private val entityName = "order"

    private val dtoType = "create"

    private val validator = validator()

    @Test
    @DisplayName("Order create DTO deserialization test - correct")
    fun testCorrectOrderCreateDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<OrderCreateDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(correctOrderCreateDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Order create DTO deserialization test - incorrect")
    fun testIncorrectOrderCreateDtoDeserialization() {
        val filename = "incorrect.json"
        val json = readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            fromJson<OrderCreateDto>(json)
        }
    }

    @Test
    @DisplayName("Order create DTO deserialization test - invalid")
    fun testInvalidOrderCreateDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<OrderCreateDto>(actualJson)
        assertFalse(validator.isValid(actual))
    }
}
