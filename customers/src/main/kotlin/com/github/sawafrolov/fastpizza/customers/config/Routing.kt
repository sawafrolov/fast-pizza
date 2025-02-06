package com.github.sawafrolov.fastpizza.customers.config

import com.github.sawafrolov.fastpizza.customers.controllers.deleteCustomer
import com.github.sawafrolov.fastpizza.customers.controllers.getCustomer
import com.github.sawafrolov.fastpizza.customers.controllers.updateCustomer
import com.github.sawafrolov.fastpizza.starter.configureAuth
import com.github.sawafrolov.fastpizza.starter.configureSerialization
import com.github.sawafrolov.fastpizza.starter.configureStatusPages
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    configureAuth()
    configureStatusPages()
    configureSerialization()

    routing {
        authenticate("auth-jwt") {
            route("/customers") {
                getCustomer()
                updateCustomer()
                deleteCustomer()
            }
        }
    }
}
