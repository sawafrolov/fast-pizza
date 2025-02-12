package com.github.sawafrolov.fastpizza.common.dto.customer

import com.github.sawafrolov.fastpizza.common.util.serializers.UuidSerializer
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable
import java.util.UUID

/**
 * DTO отображения данных пользователя
 */
@Serializable
data class CustomerViewDto(

    /**
     * UUID
     */
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID,

    /**
     * Адрес электронной почты
     */
    val email: String,

    /**
     * Номер телефона
     */
    val phoneNumber: String,

    /**
     * Имя
     */
    val firstName: String,

    /**
     * Фамилия
     */
    @Nullable
    val lastName: String?,

    /**
     * Отчество
     */
    @Nullable
    val patronymic: String?,

    /**
     * Список адресов
     */
    @Nullable
    val addresses: List<String>?,

    @Nullable
    val pizzas: Map<String, Int>?
)
