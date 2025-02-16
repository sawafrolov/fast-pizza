package com.github.sawafrolov.fastpizza.iamproxy.config

import com.github.sawafrolov.fastpizza.iamproxy.controllers.changePassword
import com.github.sawafrolov.fastpizza.iamproxy.controllers.login
import com.github.sawafrolov.fastpizza.iamproxy.controllers.register
import com.github.sawafrolov.fastpizza.starter.configureSerialization
import com.github.sawafrolov.fastpizza.starter.configureStatusPages
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    configureStatusPages()
    configureSerialization()

    routing {
        login()
        register()
        changePassword()
    }
}
