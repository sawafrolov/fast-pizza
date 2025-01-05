package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.ObjectUtil
import com.github.sawafrolov.fastpizza.common.util.ValidationUtil
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

    @Test
    @DisplayName("Order change status DTO deserialization test - correct")
    fun testCorrectOrderChangeStatusDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<OrderChangeStatusDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.correctOrderChangeStatusDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Order change status DTO deserialization test - incorrect")
    fun testIncorrectOrderChangeStatusDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<OrderChangeStatusDto>(json)
        }
    }

    @Test
    @DisplayName("Order change status DTO deserialization test - invalid")
    fun testInvalidOrderChangeStatusDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<SerializationException> {
            JsonUtil.fromJson<OrderChangeStatusDto>(actualJson)
        }
    }
}
