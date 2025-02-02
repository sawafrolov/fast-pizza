package com.github.sawafrolov.fastpizza.customers.config

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerRegistrationDto
import com.github.sawafrolov.fastpizza.customers.services.CustomerService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jakarta.validation.Validator
import org.koin.java.KoinJavaComponent.inject

private val validator: Validator by inject(Validator::class.java)

private val customerService: CustomerService by inject(CustomerService::class.java)

fun Application.configureRouting() {
    configureStatusPages()
    configureSerialization()

    routing {
        route("/customers") {
            post("/register") {
                val registrationDto = call.receive<CustomerRegistrationDto>()
                val violations = validator.validate(registrationDto)
                if (violations.isNotEmpty()) {
                    throw BadRequestException("Registration invalid: $violations")
                }
                customerService.register(registrationDto)
                call.respondText("Customer successfully registered", status = HttpStatusCode.Created)
            }
        }
    }
}
