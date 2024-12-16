package com.github.sawafrolov.fastpizza.common.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

/**
 * Таблица для сущности пользователя
 */
object CustomerTable: UUIDTable(name = "customer", columnName = "uuid") {

    // Основные поля
    val email = varchar("email", 50)
    val password = text("password")
    val phoneNumber = varchar("phone_number", 50)
    val firstName = varchar("first_name", 50)
    val lastName = varchar("last_name", 50).nullable()
    val patronymic = varchar("patronymic", 50).nullable()
    val addresses = array<String>("addresses")

    // Служебные поля
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").nullable()
    val deletedAt = datetime("deleted_at").nullable()
    val deleted = bool("deleted").default(false)
}
