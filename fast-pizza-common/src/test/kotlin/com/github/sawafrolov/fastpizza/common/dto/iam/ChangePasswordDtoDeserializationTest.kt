package com.github.sawafrolov.fastpizza.common.dto.iam

import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.test.correctChangePasswordDto
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
 * Тестирование десериализации DTO смены пароля
 */
class ChangePasswordDtoDeserializationTest {

    private val entityName = "iam"

    private val dtoType = "changePassword"

    private val validator= validator()

    @Test
    @DisplayName("Change password DTO deserialization test - correct")
    fun testCorrectChangePasswordDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<ChangePasswordDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(correctChangePasswordDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Change password DTO deserialization test - incorrect")
    fun testIncorrectChangePasswordDtoDeserialization() {
        val filename = "incorrect.json"
        val json = readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            fromJson<ChangePasswordDto>(json)
        }
    }

    @Test
    @DisplayName("Change password DTO deserialization test - invalid")
    fun testInvalidChangePasswordDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<ChangePasswordDto>(actualJson)
        assertFalse(validator.isValid(actual))
    }
}
