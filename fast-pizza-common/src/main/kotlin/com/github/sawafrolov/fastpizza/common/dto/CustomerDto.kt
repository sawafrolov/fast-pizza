package com.github.sawafrolov.fastpizza.common.dto

import com.github.sawafrolov.fastpizza.common.util.UuidSerializer
import java.util.UUID
import kotlinx.serialization.*

/**
 * DTO пользователя
 */
@Serializable
data class CustomerDto(
    @Serializable(with = UuidSerializer::class)
    val uuid: UUID?,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String?,
    val patronymic: String?,
    val addresses: List<String>
)
