package com.github.sawafrolov.fastpizza.iamproxy.controllers

import com.github.sawafrolov.fastpizza.common.dto.iam.ChangePasswordDto
import com.github.sawafrolov.fastpizza.common.dto.iam.LoginDto
import com.github.sawafrolov.fastpizza.common.dto.iam.RegistrationDto
import com.github.sawafrolov.fastpizza.common.util.jwt.createAuthToken
import com.github.sawafrolov.fastpizza.iamproxy.services.IamService
import com.github.sawafrolov.fastpizza.starter.util.validateDto
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jakarta.validation.Validator
import org.koin.java.KoinJavaComponent.inject

private val validator: Validator by inject(Validator::class.java)

private val iamService: IamService by inject(IamService::class.java)

fun Route.login() {
    post("/login") {
        val loginDto = call.receive<LoginDto>()
        validator.validateDto(loginDto, "Login DTO invalid")
        val userId = iamService.login(loginDto)
        val token = createAuthToken(userId)
        call.response.status(HttpStatusCode.OK)
        call.respond(token)
    }
}

fun Route.register() {
    post("/register") {
        val registrationDto = call.receive<RegistrationDto>()
        validator.validateDto(registrationDto, "Registration DTO invalid")
        val userId = iamService.register(registrationDto)
        val token = createAuthToken(userId)
        call.response.status(HttpStatusCode.Created)
        call.respond(token)
    }
}

fun Route.changePassword() {
    put("/password") {
        val changePasswordDto = call.receive<ChangePasswordDto>()
        validator.validateDto(changePasswordDto, "Change password DTO invalid")
        iamService.changePassword(changePasswordDto)
        call.response.status(HttpStatusCode.NoContent)
    }
}
