package com.github.sawafrolov.fastpizza.common.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime

/**
 * Таблица для сущности пиццы
 */
object PizzaTable: UUIDTable(name = "pizza", columnName = "uuid") {

    // Основные поля
    val name = varchar("name", 50)
    val description = text("description").nullable()
    val weight = integer("weight")
    val price = decimal("price", precision = 9, scale = 2)
    val ingredients = array<String>("ingredients")

    // Служебные поля
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").nullable()
    val deletedAt = datetime("deleted_at").nullable()
    val deleted = bool("deleted").default(false)
}
