package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.ObjectUtil
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
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(ObjectUtil.correctCustomerViewDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }

    @Test
    @DisplayName("Customer view DTO serialization test - full")
    fun testFullCustomerViewDtoSerialization() {
        val filename = "full.json"
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(ObjectUtil.fullCustomerViewDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }
}
