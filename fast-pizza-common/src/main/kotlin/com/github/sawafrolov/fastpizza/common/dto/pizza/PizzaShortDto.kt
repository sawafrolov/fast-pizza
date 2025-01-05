package com.github.sawafrolov.fastpizza.common.dto.pizza

import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
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
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID,

    /**
     * Название
     */
    val name: String
)
