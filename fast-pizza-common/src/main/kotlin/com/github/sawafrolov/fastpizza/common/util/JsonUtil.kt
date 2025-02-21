package com.github.sawafrolov.fastpizza.common.util

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import java.io.File

private const val basePath = "src/test/resources/json"

val jsonSerializer = Json {
    explicitNulls = false
}

fun readJson(dtoType: String, filename: String): String =
    File("$basePath/$dtoType/$filename")
        .readText(Charsets.UTF_8)

inline fun <reified T: Any> fromJson(json: String): T =
    jsonSerializer.decodeFromString<T>(json)

inline fun <reified T: Any> toJson(value: T): String =
    jsonSerializer.encodeToString(value)

fun compareJsons(expectedJson: String, actualJson: String): Boolean {
    val expected = parseJson(expectedJson)
    val actual = parseJson(actualJson)
    return expected == actual
}

private fun parseJson(json: String): JsonObject =
    jsonSerializer.decodeFromString<JsonObject>(json)
