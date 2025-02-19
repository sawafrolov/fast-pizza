package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.json.compareJsons
import com.github.sawafrolov.fastpizza.common.util.json.readJson
import com.github.sawafrolov.fastpizza.common.util.json.toJson
import com.github.sawafrolov.fastpizza.common.util.test.correctPizzaShortDto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Тестирование сериализации PizzaShortDto
 */
class PizzaShortDtoSerializationTest {

    private val dtoType = "short"

    @Test
    @DisplayName("Pizza short DTO serialization test - correct")
    fun testCorrectPizzaShortDtoSerialization() {
        val filename = "correct.json"
        val expectedJson = readJson(dtoType, filename)
        val actualJson = toJson(correctPizzaShortDto)
        compareJsons(expectedJson, actualJson)
    }
}
