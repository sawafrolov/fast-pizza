package com.github.sawafrolov.fastpizza.orders

import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.toJson
import com.github.sawafrolov.fastpizza.common.util.jwt.createAuthToken
import com.github.sawafrolov.fastpizza.common.util.test.correctOrderChangeStatusDto
import com.github.sawafrolov.fastpizza.common.util.test.correctOrderCreateDto
import com.github.sawafrolov.fastpizza.common.util.test.correctOrderViewDto
import com.github.sawafrolov.fastpizza.common.util.test.fullCustomerViewDto
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.UUID

class OrdersRoutingTest {

    private val orderId = correctOrderViewDto.uuid

    private val customerId = fullCustomerViewDto.uuid

    private val authToken = createAuthToken(customerId)

    private val jsonContentType = ContentType.Application.Json

    @Test
    @DisplayName("Test create order")
    fun testCreateOrder() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(correctOrderCreateDto)
        val response = client.post("/orders") {
            bearerAuth(authToken)
            setBody(requestBody)
            contentType(jsonContentType)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.Created, response.status)
        val actual = fromJson<OrderViewDto>(response.body<String>())
        assertEquals(correctOrderViewDto, actual)
    }

    @Test
    @DisplayName("Test find orders")
    fun testFindOrders() = testApplication {
        application {
            module()
        }
        val response = client.get("/orders") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    @DisplayName("Test get order by id")
    fun testGetOrderById() = testApplication {
        application {
            module()
        }
        val response = client.get("/orders/$orderId") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
        val actual = fromJson<OrderViewDto>(response.body<String>())
        assertEquals(correctOrderViewDto, actual)
    }

    @Test
    @DisplayName("Test get order by not exist id")
    fun testGetCustomerByNotExistId() = testApplication {
        application {
            module()
        }
        val randomId = UUID.randomUUID().toString()
        val response = client.get("/orders/$randomId") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.NotFound, response.status)
    }

    @Test
    @DisplayName("Test update order status")
    fun testUpdateOrderStatus() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(correctOrderChangeStatusDto)
        val response = client.put("/orders/$orderId/status") {
            bearerAuth(authToken)
            setBody(requestBody)
            contentType(jsonContentType)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
        val expected = correctOrderViewDto.copy(status = correctOrderChangeStatusDto.status)
        val actual = fromJson<OrderViewDto>(response.body<String>())
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Test delete order by id")
    fun testDeleteOrderById() = testApplication {
        application {
            module()
        }
        val response = client.delete("/orders/$orderId") {
            bearerAuth(authToken)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.NoContent, response.status)
    }
}
