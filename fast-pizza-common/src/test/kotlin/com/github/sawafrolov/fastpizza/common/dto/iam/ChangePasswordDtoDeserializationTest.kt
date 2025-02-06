package com.github.sawafrolov.fastpizza.common.dto.iam

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.ValidationUtil
import com.github.sawafrolov.fastpizza.common.util.test.correctChangePasswordDto
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
class ChangePasswordDtoDeserializationTest {

    private val entityName = "iam"

    private val dtoType = "changePassword"

    @Test
    @DisplayName("Customer change password DTO deserialization test - correct")
    fun testCorrectCustomerChangePasswordDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<ChangePasswordDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(correctChangePasswordDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Customer change password DTO deserialization test - incorrect")
    fun testIncorrectCustomerChangePasswordDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<ChangePasswordDto>(json)
        }
    }

    @Test
    @DisplayName("Customer change password DTO deserialization test - invalid")
    fun testInvalidCustomerChangePasswordDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<ChangePasswordDto>(actualJson)
        assertFalse(ValidationUtil.isValid(actual))
    }
}
