package com.github.sawafrolov.fastpizza.orders.mappers

import com.github.sawafrolov.fastpizza.common.util.test.ObjectUtil
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.assertEquals

class PizzaMapperTest {

    private val pizzaMapper: PizzaMapper by inject(PizzaMapper::class.java)

    @Test
    @DisplayName("Test map pizza create DTO to pizza entity")
    fun testMapToEntity() {
        val expected = ObjectUtil.pizzaEntity
        val actual = pizzaMapper.mapToEntity(ObjectUtil.fullPizzaCreateDto)
        assertEquals(expected, actual)
    }
}
