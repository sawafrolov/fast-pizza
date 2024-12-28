package com.github.sawafrolov.fastpizza.common.dto.order

import com.github.sawafrolov.fastpizza.common.dto.OrderItemDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable
import java.util.UUID

@Serializable
data class OrderViewDto(

    @Nullable
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID?,

    @field:NotNull
    val customer: CustomerViewDto,

    @field:NotEmpty
    val cast: List<OrderItemDto>
)
