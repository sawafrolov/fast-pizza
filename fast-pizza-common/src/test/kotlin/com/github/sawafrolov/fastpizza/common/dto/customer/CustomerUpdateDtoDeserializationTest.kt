package com.github.sawafrolov.fastpizza.common.dto.customer

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
 * Тестирование десериализации CustomerUpdateDto
 */
class CustomerUpdateDtoDeserializationTest {

    private val entityName = "customer"

    private val dtoType = "update"

    @Test
    @DisplayName("Customer update DTO deserialization test - correct")
    fun testCorrectCustomerUpdateDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerUpdateDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.correctCustomerUpdateDto, actual)
    }

    @Test
    @DisplayName("Customer update DTO deserialization test - full")
    fun testFullCustomerUpdateDtoDeserialization() {
        val filename = "full.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerUpdateDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.fullCustomerUpdateDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Customer update DTO deserialization test - incorrect")
    fun testIncorrectCustomerUpdateDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<CustomerUpdateDto>(json)
        }
    }

    @Test
    @DisplayName("Customer update DTO deserialization test - invalid")
    fun testInvalidCustomerUpdateDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerUpdateDto>(actualJson)
        assertFalse(ValidationUtil.isValid(actual))
    }
}
