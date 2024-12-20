package com.github.sawafrolov.fastpizza.common.util

import java.io.File

class JsonUtil {

    companion object {

        fun readJson(filename: String): String {
            val basePath = "src/test/resources/json"
            return File("$basePath/$filename").readText(Charsets.UTF_8)
        }
    }
}
