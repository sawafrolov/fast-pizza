package com.github.sawafrolov.fastpizza.customers.config

import com.github.sawafrolov.fastpizza.starter.configureAuth
import com.github.sawafrolov.fastpizza.starter.configureSerialization
import com.github.sawafrolov.fastpizza.starter.configureStatusPages
import io.ktor.server.application.*

fun Application.configureRouting() {
    configureAuth()
    configureStatusPages()
    configureSerialization()
}
