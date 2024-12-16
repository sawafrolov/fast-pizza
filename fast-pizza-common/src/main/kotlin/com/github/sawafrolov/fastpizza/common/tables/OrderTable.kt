package com.github.sawafrolov.fastpizza.common.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

/**
 * Таблица для заказа
 */
object OrderTable: UUIDTable(name = "order", columnName = "uuid") {

    // Основные поля
    val customerId = reference("customer_id", CustomerTable.id)
    val totalWeight = integer("total_weight")
    val totalPrice = decimal("total_price", precision = 9, scale = 2)

    // Служебные поля
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").nullable()
    val deletedAt = datetime("deleted_at").nullable()
    val deleted = bool("deleted").default(false)
}
