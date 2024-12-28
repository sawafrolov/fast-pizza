package com.github.sawafrolov.fastpizza.common.dto.pizza

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO для редактирования данных пиццы
 */
@Serializable
data class PizzaUpdateDto(

    /**
     * UUID
     */
    @Contextual
    val uuid: UUID,

    /**
     * Описание
     */
    @Nullable
    val description: String?,

    /**
     * Масса в граммах
     */
    @field:Positive
    val weight: Int,

    /**
     * Цена в рублях
     */
    @Contextual
    @field:Positive
    val price: BigDecimal,

    /**
     * Список ингридиентов
     */
    @field:NotEmpty
    val ingredients: List<String>
)
