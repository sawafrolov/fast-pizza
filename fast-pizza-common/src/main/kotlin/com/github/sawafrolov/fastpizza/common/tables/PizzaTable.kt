package com.github.sawafrolov.fastpizza.common.tables

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.datetime

/**
 * Таблица для сущности пиццы
 */
object PizzaTable: UUIDTable(name = "pizza", columnName = "uuid") {

    // Основные поля
    val name = text("name")
    val description = text("description").nullable()
    val weight = integer("weight")
    val price = decimal("price", precision = 9, scale = 2)
    val ingredients = array<String>("ingredients")

    // Служебные поля
    val created_at = datetime("created_at").nullable()
    val updated_at = datetime("updated_at").nullable()
    val deleted_at = datetime("deleted_at").nullable()
    val deleted = bool("deleted").default(false)
}
