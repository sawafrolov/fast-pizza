package com.github.sawafrolov.fastpizza.customers

import com.github.sawafrolov.fastpizza.customers.config.configureKoin
import com.github.sawafrolov.fastpizza.customers.config.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureRouting()
}
