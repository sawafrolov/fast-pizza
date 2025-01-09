package com.github.sawafrolov.fastpizza.orders

import com.github.sawafrolov.fastpizza.orders.config.configureKoin
import com.github.sawafrolov.fastpizza.orders.config.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureSerialization()
}
