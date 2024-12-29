package com.github.sawafrolov.fastpizza.common.dto.pizza

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * DTO пиццы для отображения в заказах
 */
@Serializable
data class PizzaShortDto(

    /**
     * UUID
     */
    @Contextual
    val uuid: UUID,

    /**
     * Название
     */
    val name: String
)
