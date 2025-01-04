package com.github.sawafrolov.fastpizza.common.util

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class JsonUtil {

    companion object {

        val basePath = "src/test/resources/json"

        val jsonSerializer = Json {
            explicitNulls = false
        }

        fun readJson(entityName: String, dtoType: String, filename: String): String =
             File("$basePath/$entityName/$dtoType/$filename")
                 .readText(Charsets.UTF_8)

        inline fun <reified T: Any> toJson(value: T): String =
            jsonSerializer.encodeToString(value)

        inline fun <reified T: Any> fromJson(json: String): T =
            jsonSerializer.decodeFromString<T>(json)

        fun compareJsons(expectedJson: String, actualJson: String) {
            val expected = parseJson(expectedJson)
            val actual = parseJson(actualJson)
            assertEquals(expected, actual)
        }

        private fun parseJson(json: String): JsonObject =
            jsonSerializer.decodeFromString<JsonObject>(json)
    }
}
