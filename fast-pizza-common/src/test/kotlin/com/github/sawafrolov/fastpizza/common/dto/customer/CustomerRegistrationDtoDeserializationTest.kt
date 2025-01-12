package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.test.ObjectUtil
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
 * Тестирование десериализации CustomerRegistrationDto
 */
class CustomerRegistrationDtoDeserializationTest {

    private val entityName = "customer"

    private val dtoType = "registration"

    @Test
    @DisplayName("Customer registration DTO deserialization test - correct")
    fun testCorrectCustomerRegistrationDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerRegistrationDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.correctCustomerRegistrationDto, actual)
    }

    @Test
    @DisplayName("Customer registration DTO deserialization test - full")
    fun testFullCustomerRegistrationDtoDeserialization() {
        val filename = "full.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerRegistrationDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.fullCustomerRegistrationDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Customer registration DTO deserialization test - incorrect")
    fun testIncorrectCustomerRegistrationDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<CustomerRegistrationDto>(json)
        }
    }

    @Test
    @DisplayName("Customer registration DTO deserialization test - invalid")
    fun testInvalidCustomerRegistrationDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerRegistrationDto>(actualJson)
        assertFalse(ValidationUtil.isValid(actual))
    }
}
