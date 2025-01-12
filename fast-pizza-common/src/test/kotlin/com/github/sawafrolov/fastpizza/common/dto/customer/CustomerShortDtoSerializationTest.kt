package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.test.ObjectUtil
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
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(ObjectUtil.correctCustomerShortDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }
}
