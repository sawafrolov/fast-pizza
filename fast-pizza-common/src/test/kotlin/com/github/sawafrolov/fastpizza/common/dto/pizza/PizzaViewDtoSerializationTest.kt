package com.github.sawafrolov.fastpizza.common.dto.pizza

import com.github.sawafrolov.fastpizza.common.util.JsonUtil
import com.github.sawafrolov.fastpizza.common.util.ObjectUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тестирование сериализации PizzaShortDto
 */
class PizzaViewDtoSerializationTest {

    val entityName = "pizza"

    val dtoType = "view"

    @Test
    @DisplayName("Pizza view DTO serialization test - correct")
    fun testCorrectPizzaViewDtoSerialization() {
        val filename = "correct.json"
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(ObjectUtil.correctPizzaViewDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }

    @Test
    @DisplayName("Pizza view DTO serialization test - full")
    fun testFullPizzaViewDtoSerialization() {
        val filename = "full.json"
        val expectedJson = JsonUtil.readJson(entityName, dtoType, filename)
        val actualJson = JsonUtil.toJson(ObjectUtil.fullPizzaViewDto)
        JsonUtil.compareJsons(expectedJson, actualJson)
    }
}
