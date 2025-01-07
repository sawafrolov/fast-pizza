package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.serializers.UuidSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * DTO пользователя для отображения в заказах
 */
@Serializable
data class CustomerShortDto(

    /**
     * UUID
     */
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID,

    /**
     * Адрес электронной почты
     */
    val email: String
)
