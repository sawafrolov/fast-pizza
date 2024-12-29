package com.github.sawafrolov.fastpizza.common.dto.customer

import kotlinx.serialization.Contextual
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
    @Contextual
    val uuid: UUID,

    /**
     * Адрес электронной почты
     */
    val email: String
)
