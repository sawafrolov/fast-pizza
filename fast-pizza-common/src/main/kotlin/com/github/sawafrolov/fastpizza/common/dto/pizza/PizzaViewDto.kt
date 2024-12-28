package com.github.sawafrolov.fastpizza.common.dto.pizza

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO для отображения данных пиццы
 */
@Serializable
data class PizzaViewDto(

    /**
     * UUID
     */
    @Contextual
    val uuid: UUID,

    /**
     * Название
     */
    val name: String,

    /**
     * Описание
     */
    @Nullable
    val description: String?,

    /**
     * Масса в граммах
     */
    val weight: Int,

    /**
     * Цена в рублях
     */
    @Contextual
    val price: BigDecimal,

    /**
     * Список ингридиентов
     */
    val ingredients: List<String>
)
