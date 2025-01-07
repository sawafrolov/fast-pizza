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
 * Тестирование десериализации CustomerChangePasswordDto
 */
class CustomerChangePasswordDtoDeserializationTest {

    private val entityName = "customer"

    private val dtoType = "changePassword"

    @Test
    @DisplayName("Customer change password DTO deserialization test - correct")
    fun testCorrectCustomerChangePasswordDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerChangePasswordDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(ObjectUtil.correctCustomerChangePasswordDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Customer change password DTO deserialization test - incorrect")
    fun testIncorrectCustomerChangePasswordDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<CustomerChangePasswordDto>(json)
        }
    }

    @Test
    @DisplayName("Customer change password DTO deserialization test - invalid")
    fun testInvalidCustomerChangePasswordDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<CustomerChangePasswordDto>(actualJson)
        assertFalse(ValidationUtil.isValid(actual))
    }
}
