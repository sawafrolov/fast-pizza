package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.util.json.compareJsons
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.json.toJson
import com.github.sawafrolov.fastpizza.common.util.test.correctCustomerShortDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тестирование сериализации CustomerShortDto
 */
class CustomerShortDtoSerializationTest {

    val entityName = "customer"

    val dtoType = "short"

    @Test
    @DisplayName("Customer short DTO serialization test - correct")
    fun testCorrectCustomerShortDtoSerialization() {
        val filename = "correct.json"
        val expectedJson = readJson(entityName, dtoType, filename)
        val actualJson = toJson(correctCustomerShortDto)
        compareJsons(expectedJson, actualJson)
    }
}
