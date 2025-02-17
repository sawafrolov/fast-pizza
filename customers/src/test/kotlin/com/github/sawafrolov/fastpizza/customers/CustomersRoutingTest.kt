package com.github.sawafrolov.fastpizza.customers

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.util.json.fromJson
import com.github.sawafrolov.fastpizza.common.util.json.toJson
import com.github.sawafrolov.fastpizza.common.util.jwt.createAuthToken
import com.github.sawafrolov.fastpizza.common.util.test.fullCustomerUpdateDto
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

class CustomersRoutingTest {

    private val customerId = fullCustomerViewDto.uuid

    private val authToken = createAuthToken(customerId)

    private val jsonContentType = ContentType.Application.Json

    @Test
    @DisplayName("Test get customer by id")
    fun testGetCustomerById() = testApplication {
        application {
            module()
        }
        val response = client.get("/customers/$customerId") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
        val actual = fromJson<CustomerViewDto>(response.body<String>())
        assertEquals(fullCustomerViewDto, actual)
    }

    @Test
    @DisplayName("Test get customer by not exist id")
    fun testGetCustomerByNotExistId() = testApplication {
        application {
            module()
        }
        val randomId = UUID.randomUUID().toString()
        val response = client.get("/customers/$randomId") {
            bearerAuth(authToken)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.Forbidden, response.status)
    }

    @Test
    @DisplayName("Test update customer")
    fun testUpdateCustomer() = testApplication {
        application {
            module()
        }
        val requestBody = toJson(fullCustomerUpdateDto)
        val response = client.put("/customers/$customerId") {
            bearerAuth(authToken)
            setBody(requestBody)
            contentType(jsonContentType)
            accept(jsonContentType)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.OK, response.status)
        val actual = fromJson<CustomerViewDto>(response.body<String>())
        assertEquals(fullCustomerViewDto, actual)
    }

    @Test
    @DisplayName("Test delete customer by id")
    fun testDeleteCustomerById() = testApplication {
        application {
            module()
        }
        val response = client.delete("/customers/$customerId") {
            bearerAuth(authToken)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.NoContent, response.status)
    }

    @Test
    @DisplayName("Test delete customer by not exist id")
    fun testDeleteCustomerByNotExistId() = testApplication {
        application {
            module()
        }
        val randomId = UUID.randomUUID().toString()
        val response = client.delete("/customers/$randomId") {
            bearerAuth(authToken)
        }
        assertNotNull(response)
        assertEquals(HttpStatusCode.Forbidden, response.status)
    }
}
