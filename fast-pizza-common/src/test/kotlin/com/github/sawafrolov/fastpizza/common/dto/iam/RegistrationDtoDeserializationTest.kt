package com.github.sawafrolov.fastpizza.common.dto.iam

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.ValidationUtil
import com.github.sawafrolov.fastpizza.common.util.test.correctRegistrationDto
import com.github.sawafrolov.fastpizza.common.util.test.fullRegistrationDto
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Тестирование десериализации DTO регистрации
 */
class RegistrationDtoDeserializationTest {

    private val entityName = "iam"

    private val dtoType = "registration"

    @Test
    @DisplayName("Registration DTO deserialization test - correct")
    fun testCorrectRegistrationDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<RegistrationDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(correctRegistrationDto, actual)
    }

    @Test
    @DisplayName("Registration DTO deserialization test - full")
    fun testFullRegistrationDtoDeserialization() {
        val filename = "full.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<RegistrationDto>(actualJson)
        assertTrue(ValidationUtil.isValid(actual))
        assertEquals(fullRegistrationDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Registration DTO deserialization test - incorrect")
    fun testIncorrectRegistrationDtoDeserialization() {
        val filename = "incorrect.json"
        val json = JsonUtil.readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            JsonUtil.fromJson<RegistrationDto>(json)
        }
    }

    @Test
    @DisplayName("Registration DTO deserialization test - invalid")
    fun testInvalidRegistrationDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actual = JsonUtil.fromJson<RegistrationDto>(actualJson)
        assertFalse(ValidationUtil.isValid(actual))
    }
}
