package com.github.sawafrolov.fastpizza.common.dto.pizza

import com.github.sawafrolov.fastpizza.common.util.BigDecimalSerializer
import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable
import java.math.BigDecimal
import java.util.UUID

/**
 * DTO пиццы
 */
@Serializable
data class PizzaDto(

    @Nullable
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID?,

    @field:NotBlank
    @field:Size(min = 3, max = 32)
    val name: String,

    @Nullable
    val description: String?,

    @field:Positive
    val weight: Int,

    @field:Positive
    @Serializable(with = BigDecimalSerializer::class)
    val price: BigDecimal,

    @field:NotEmpty
    val ingredients: List<String>
)
