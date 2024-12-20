package com.github.sawafrolov.fastpizza.orders

//import com.github.sawafrolov.fastpizza.common.dto.PizzaDto
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeserializationTest {

    @Test
    fun testPizza() = testApplication {
        application {
            module()
        }
        val data = """
            {
                \"name\": \"Test Pizza\",
                \"weight\": 345,
                \"price\": "600.00",
                \"ingredients\": [\"Cheese\", \"Tomatoes\"]
            }
        """.trimIndent()
        val response = client.post {
            contentType(ContentType.Application.Json)
            setBody(data)
        }
        //val body = response.body<PizzaDto>()
        //assertEquals(body.ingredients.size, 2)
    }
}
