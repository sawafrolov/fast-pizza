package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.test.correctCustomerUpdateDto
import com.github.sawafrolov.fastpizza.common.util.test.fullCustomerUpdateDto
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
 * Тестирование десериализации CustomerUpdateDto
 */
class CustomerUpdateDtoDeserializationTest {

    private val entityName = "customer"

    private val dtoType = "update"

    private val validator = validator()

    @Test
    @DisplayName("Customer update DTO deserialization test - correct")
    fun testCorrectCustomerUpdateDtoDeserialization() {
        val filename = "correct.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<CustomerUpdateDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(correctCustomerUpdateDto, actual)
    }

    @Test
    @DisplayName("Customer update DTO deserialization test - full")
    fun testFullCustomerUpdateDtoDeserialization() {
        val filename = "full.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<CustomerUpdateDto>(actualJson)
        assertTrue(validator.isValid(actual))
        assertEquals(fullCustomerUpdateDto, actual)
    }

    @Test
    @OptIn(ExperimentalSerializationApi::class)
    @DisplayName("Customer update DTO deserialization test - incorrect")
    fun testIncorrectCustomerUpdateDtoDeserialization() {
        val filename = "incorrect.json"
        val json = readJson(entityName, dtoType, filename)
        assertThrows<MissingFieldException> {
            fromJson<CustomerUpdateDto>(json)
        }
    }

    @Test
    @DisplayName("Customer update DTO deserialization test - invalid")
    fun testInvalidCustomerUpdateDtoDeserialization() {
        val filename = "invalid.json"
        val actualJson = readJson(entityName, dtoType, filename)
        val actual = fromJson<CustomerUpdateDto>(actualJson)
        assertFalse(validator.isValid(actual))
    }
}
