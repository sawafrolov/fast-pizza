package com.github.sawafrolov.fastpizza.common.dto.pizza

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable
import java.math.BigDecimal

/**
 * DTO для создания пиццы
 */
@Serializable
data class PizzaCreateDto(

    /**
     * Название
     */
    @field:NotBlank
    @field:Size(min = 3, max = 32)
    val name: String,

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
