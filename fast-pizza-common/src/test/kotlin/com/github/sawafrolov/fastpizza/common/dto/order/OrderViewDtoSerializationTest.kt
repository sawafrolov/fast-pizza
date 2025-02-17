package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.util.json.compareJsons
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.json.toJson
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
        val expectedJson = readJson(entityName, dtoType, filename)
        val actualJson = toJson(correctOrderViewDto)
        compareJsons(expectedJson, actualJson)
    }
}
