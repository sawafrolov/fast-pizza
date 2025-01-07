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
 * Тестирование десериализации CustomerLoginDto
 */
class CustomerLoginDtoDeserializationTest {

    private val entityName = "customer"

    private val dtoType = "login"

    @Test
    @DisplayName("Customer login DTO deserialization test - correct")
    fun testCorrectCustomerLoginDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerLoginDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.correctCustomerLoginDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Customer login DTO deserialization test - incorrect")
    fun testIncorrectCustomerLoginDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<CustomerLoginDto>(json)
        }
    }

    @Test
    @DisplayName("Customer login DTO deserialization test - invalid")
    fun testInvalidCustomerLoginDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerLoginDto>(actualJson)
        assertFalse(ValidationUtil.isValid(actual))
    }
}
