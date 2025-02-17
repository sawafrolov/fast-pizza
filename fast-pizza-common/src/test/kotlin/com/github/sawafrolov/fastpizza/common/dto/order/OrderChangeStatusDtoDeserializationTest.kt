package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.test.correctOrderChangeStatusDto
import com.github.sawafrolov.fastpizza.common.util.validation.isValid
import com.github.sawafrolov.fastpizza.common.util.validation.validator
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.SerializationException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Тестирование десериализации OrderChangeStatusDto
 */
class OrderChangeStatusDtoDeserializationTest {

    private val entityName = "order"

    private val dtoType = "changeStatus"

    private val validator = validator()

    @Test
    @DisplayName("Order change status DTO deserialization test - correct")
    fun testCorrectOrderChangeStatusDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<OrderChangeStatusDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(correctOrderChangeStatusDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Order change status DTO deserialization test - incorrect")
    fun testIncorrectOrderChangeStatusDtoDeserialization() {
        val filename = "incorrect.json"
        val json = readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            fromJson<OrderChangeStatusDto>(json)
        }
    }

    @Test
    @DisplayName("Order change status DTO deserialization test - invalid")
    fun testInvalidOrderChangeStatusDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = readJson(entityName, dtoType, filename)
        assertThrows<SerializationException> {
            fromJson<OrderChangeStatusDto>(actualJson)
        }
    }
}
