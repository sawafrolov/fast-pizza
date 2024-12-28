package com.github.sawafrolov.fastpizza.common.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime
import java.util.UUID

/**
 * Таблица для заказа
 */
object OrderTable: UUIDTable(name = "order", columnName = "uuid") {

    // Основные поля
    val customer = reference("customer_id", CustomerTable.id)
    val cast = array<UUID>("cast")
    val address = varchar("address", 100)
    val totalWeight = integer("total_weight")
    val totalPrice = decimal("total_price", precision = 9, scale = 2)
    val status = varchar("status", 10)

    // Служебные поля
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").nullable()
    val deletedAt = datetime("deleted_at").nullable()
    val deleted = bool("deleted").default(false)
}
