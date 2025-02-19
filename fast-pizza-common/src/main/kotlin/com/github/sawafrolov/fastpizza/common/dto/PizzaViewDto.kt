package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.serializers.BigDecimalSerializer
import com.github.sawafrolov.fastpizza.common.util.serializers.UuidSerializer
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
    @Serializable(with = UuidSerializer::class)
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
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,

    /**
     * Список ингридиентов
     */
    val ingredients: List<String>
)
