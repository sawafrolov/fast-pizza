package com.github.sawafrolov.fastpizza.iamproxy

import com.github.sawafrolov.fastpizza.common.util.json.toJson
import com.github.sawafrolov.fastpizza.common.util.jwt.jwtVerifier
import com.github.sawafrolov.fastpizza.common.util.test.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AuthRoutingTest {

    private val jsonContentType = ContentType.Application.Json

    private val plainTextContentType = ContentType.Text.Plain

    @Test
    @DisplayName("Test login")
    fun testLogin() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(correctLoginDto)
        val response = client.post("/login") {
            setBody(requestBody)
            contentType(jsonContentType)
            accept(plainTextContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
        jwtVerifier.verify(response.body<String>())
    }

    @Test
    @DisplayName("Test registration")
    fun testRegistration() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(correctRegistrationDto)
        val response = client.post("/register") {
            setBody(requestBody)
            contentType(jsonContentType)
            accept(plainTextContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.Created, response.status)
        jwtVerifier.verify(response.body<String>())
    }

    @Test
    @DisplayName("Test change password")
    fun testChangePassword() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(correctChangePasswordDto)
        val response = client.put("/password") {
            setBody(requestBody)
            contentType(jsonContentType)
            accept(plainTextContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.NoContent, response.status)
    }
}
