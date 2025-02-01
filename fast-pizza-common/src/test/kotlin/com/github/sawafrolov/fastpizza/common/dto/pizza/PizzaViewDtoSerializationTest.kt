package com.github.sawafrolov.fastpizza.common.dto.pizza

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.test.correctPizzaViewDto
import com.github.sawafrolov.fastpizza.common.util.test.fullPizzaViewDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тестирование сериализации PizzaViewDto
 */
class PizzaViewDtoSerializationTest {

    val entityName = "pizza"

    val dtoType = "view"

    @Test
    @DisplayName("Pizza view DTO serialization test - correct")
    fun testCorrectPizzaViewDtoSerialization() {
        val filename = "correct.json"
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(correctPizzaViewDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }

    @Test
    @DisplayName("Pizza view DTO serialization test - full")
    fun testFullPizzaViewDtoSerialization() {
        val filename = "full.json"
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(fullPizzaViewDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }
}
