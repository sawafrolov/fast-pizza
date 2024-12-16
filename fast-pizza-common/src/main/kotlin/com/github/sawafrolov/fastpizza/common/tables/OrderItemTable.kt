package com.github.sawafrolov.fastpizza.common.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

/**
 * Таблица для OrderItem
 */
object OrderItemTable: UUIDTable(name = "order_item", columnName = "uuid") {

    // Основные поля
    val pizzaId = uuid("pizza_id").references(PizzaTable.id)
    val orderId = uuid("order_id").references(OrderTable.id)
    val quantity = integer("quantity")

    // Служебные поля
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").nullable()
    val deletedAt = datetime("deleted_at").nullable()
    val deleted = bool("deleted").default(false)
}
