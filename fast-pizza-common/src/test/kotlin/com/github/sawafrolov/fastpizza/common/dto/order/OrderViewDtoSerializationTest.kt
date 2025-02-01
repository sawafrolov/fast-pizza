package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.test.correctOrderViewDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тестирование сериализации OrderViewDto
 */
class OrderViewDtoSerializationTest {

    val entityName = "order"

    val dtoType = "view"

    @Test
    @DisplayName("Order view DTO serialization test - correct")
    fun testCorrectOrderViewDtoSerialization() {
        val filename = "correct.json"
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(correctOrderViewDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }
}
