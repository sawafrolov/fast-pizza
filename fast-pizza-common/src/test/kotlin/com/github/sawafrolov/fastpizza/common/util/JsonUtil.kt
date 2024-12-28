package com.github.sawafrolov.fastpizza.common.util

import kotlinx.serialization.json.Json
import java.io.File

class JsonUtil {

    companion object {

        val jsonDecoder = Json {
            explicitNulls = false
        }

        inline fun <reified T: Any> readJson(filename: String, targetClass: Class<T>): T {
            val basePath = "src/test/resources/json"
            val json = File("$basePath/$filename").readText(Charsets.UTF_8)
            return jsonDecoder.decodeFromString<T>(json)
        }
    }
}
