package com.github.sawafrolov.fastpizza.common.dto.iam

import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.test.correctLoginDto
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
 * Тестирование десериализации DTO авторизации
 */
class LoginDtoDeserializationTest {

    private val entityName = "iam"

    private val dtoType = "login"

    private val validator = validator()

    @Test
    @DisplayName("Login DTO deserialization test - correct")
    fun testCorrectLoginDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<LoginDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(correctLoginDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Login DTO deserialization test - incorrect")
    fun testIncorrectLoginDtoDeserialization() {
        val filename = "incorrect.json"
        val json = readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            fromJson<LoginDto>(json)
        }
    }

    @Test
    @DisplayName("Login DTO deserialization test - invalid")
    fun testInvalidLoginDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<LoginDto>(actualJson)
        assertFalse(validator.isValid(actual))
    }
}
