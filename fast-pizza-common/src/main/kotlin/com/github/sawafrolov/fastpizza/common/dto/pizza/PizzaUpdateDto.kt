package com.github.sawafrolov.fastpizza.common.dto.pizza

import com.github.sawafrolov.fastpizza.common.serializers.BigDecimalSerializer
import com.github.sawafrolov.fastpizza.common.serializers.UuidSerializer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
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
    @Serializable(with = UuidSerializer::class)
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
    @field:Positive
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,

    /**
     * Список ингридиентов
     */
    @field:NotEmpty
    val ingredients: List<String>
)
