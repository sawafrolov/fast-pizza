package com.github.sawafrolov.fastpizza.common.dto

import java.util.UUID

/**
 * DTO пользователя
 */
data class CustomerDto(
    val uuid: UUID?,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String?,
    val patronymic: String?,
    val addresses: List<String>
)
