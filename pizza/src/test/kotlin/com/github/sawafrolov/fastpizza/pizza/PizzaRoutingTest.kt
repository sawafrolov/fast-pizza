package com.github.sawafrolov.fastpizza.pizza

import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaViewDto
import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.toJson
import com.github.sawafrolov.fastpizza.common.util.jwt.createAuthToken
import com.github.sawafrolov.fastpizza.common.util.test.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.UUID

class PizzaRoutingTest {

    private val pizzaId = fullPizzaViewDto.uuid

    private val customerId = fullCustomerViewDto.uuid

    private val authToken = createAuthToken(customerId)

    private val jsonContentType = ContentType.Application.Json

    @Test
    @DisplayName("Test create pizza")
    fun testCreatePizza() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(fullPizzaCreateDto)
        val response = client.post("/pizza") {
            bearerAuth(authToken)
            setBody(requestBody)
            contentType(jsonContentType)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.Created, response.status)
        val actual = fromJson<PizzaViewDto>(response.body<String>())
        assertEquals(fullPizzaViewDto, actual)
    }

    @Test
    @DisplayName("Test find pizzas")
    fun testFindPizzas() = testApplication {
        application {
            module()
        }
        val response = client.get("/pizza") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    @DisplayName("Test get pizza by id")
    fun testGetPizzaById() = testApplication {
        application {
            module()
        }
        val response = client.get("/pizza/$pizzaId") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
        val actual = fromJson<PizzaViewDto>(response.body<String>())
        assertEquals(fullPizzaViewDto, actual)
    }

    @Test
    @DisplayName("Test get pizza by not exist id")
    fun testGetPizzaByNotExistId() = testApplication {
        application {
            module()
        }
        val randomId = UUID.randomUUID().toString()
        val response = client.get("/pizza/$randomId") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.NotFound, response.status)
    }

    @Test
    @DisplayName("Test update pizza")
    fun testUpdatePizza() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(fullPizzaUpdateDto)
        val response = client.put("/pizza/$pizzaId") {
            bearerAuth(authToken)
            setBody(requestBody)
            contentType(jsonContentType)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
        val actual = fromJson<PizzaViewDto>(response.body<String>())
        assertEquals(fullPizzaViewDto, actual)
    }

    @Test
    @DisplayName("Test delete pizza by id")
    fun testDeletePizzaById() = testApplication {
        application {
            module()
        }
        val response = client.delete("/pizza/$pizzaId") {
            bearerAuth(authToken)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.NoContent, response.status)
    }
}
