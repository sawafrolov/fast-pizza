package com.github.sawafrolov.fastpizza.pizza

import com.github.sawafrolov.fastpizza.pizza.config.configureKoin
import com.github.sawafrolov.fastpizza.pizza.config.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureRouting()
}
