package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.util.json.compareJsons
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.json.toJson
import com.github.sawafrolov.fastpizza.common.util.test.correctCustomerViewDto
import com.github.sawafrolov.fastpizza.common.util.test.fullCustomerViewDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тестирование сериализации CustomerViewDto
 */
class CustomerViewDtoSerializationTest {

    val entityName = "customer"

    val dtoType = "view"

    @Test
    @DisplayName("Customer view DTO serialization test - correct")
    fun testCorrectCustomerViewDtoSerialization() {
        val filename = "correct.json"
        val expectedJson = readJson(entityName, dtoType, filename)
        val actualJson = toJson(correctCustomerViewDto)
        compareJsons(expectedJson, actualJson)
    }

    @Test
    @DisplayName("Customer view DTO serialization test - full")
    fun testFullCustomerViewDtoSerialization() {
        val filename = "full.json"
        val expectedJson = readJson(entityName, dtoType, filename)
        val actualJson = toJson(fullCustomerViewDto)
        compareJsons(expectedJson, actualJson)
    }
}
