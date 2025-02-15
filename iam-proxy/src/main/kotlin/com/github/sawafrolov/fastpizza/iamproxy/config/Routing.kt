package com.github.sawafrolov.fastpizza.iamproxy.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.github.sawafrolov.fastpizza.common.dto.iam.ChangePasswordDto
import com.github.sawafrolov.fastpizza.common.dto.iam.LoginDto
import com.github.sawafrolov.fastpizza.common.dto.iam.RegistrationDto
import com.github.sawafrolov.fastpizza.iamproxy.services.IamService
import com.github.sawafrolov.fastpizza.starter.configureSerialization
import com.github.sawafrolov.fastpizza.starter.configureStatusPages
import com.github.sawafrolov.fastpizza.starter.util.validateDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import jakarta.validation.Validator
import org.koin.java.KoinJavaComponent.inject
import java.time.Instant
import java.util.UUID

private val validator: Validator by inject(Validator::class.java)

private val iamService: IamService by inject(IamService::class.java)

fun Application.configureRouting() {
    configureStatusPages()
    configureSerialization()

    fun createAuthToken(userId: UUID): String {
        val secret = environment.config.property("jwt.secret").getString()
        val audience = environment.config.property("jwt.audience").getString()
        val issuer = environment.config.property("jwt.issuer").getString()
        val expirationTimeInSeconds = environment.config.property("jwt.expiration-time-seconds").getString().toLong()
        val expirationTime = Instant.now().plusSeconds(expirationTimeInSeconds)

        return JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("uuid", userId.toString())
            .withExpiresAt(expirationTime)
            .sign(Algorithm.HMAC256(secret))
    }

    routing {
        post("/login") {
            val loginDto = call.receive<LoginDto>()
            validator.validateDto(loginDto, "Login DTO invalid")
            val userId = iamService.login(loginDto)
            val token = createAuthToken(userId)
            call.response.status(HttpStatusCode.OK)
            call.respond(token)
        }

        post("/register") {
            val registrationDto = call.receive<RegistrationDto>()
            validator.validateDto(registrationDto, "Registration DTO invalid")
            val userId = iamService.register(registrationDto)
            val token = createAuthToken(userId)
            call.response.status(HttpStatusCode.Created)
            call.respond(token)
        }

        put("/password") {
            val changePasswordDto = call.receive<ChangePasswordDto>()
            validator.validateDto(changePasswordDto, "Change password DTO invalid")
            iamService.changePassword(changePasswordDto)
            call.response.status(HttpStatusCode.NoContent)
        }
    }
}
