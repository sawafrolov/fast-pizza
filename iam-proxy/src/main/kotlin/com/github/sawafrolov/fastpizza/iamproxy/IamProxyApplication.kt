package com.github.sawafrolov.fastpizza.iamproxy

import com.github.sawafrolov.fastpizza.iamproxy.config.configureKoin
import com.github.sawafrolov.fastpizza.iamproxy.config.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureRouting()
}
