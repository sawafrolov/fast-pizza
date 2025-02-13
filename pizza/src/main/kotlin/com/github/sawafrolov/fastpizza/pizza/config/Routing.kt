package com.github.sawafrolov.fastpizza.pizza.config

import com.github.sawafrolov.fastpizza.pizza.controller.*
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
            route("/pizza") {
                createPizza()
                findAllPizzas()
                findPizzaById()
                updatePizza()
                deletePizza()
            }
        }
    }
}
