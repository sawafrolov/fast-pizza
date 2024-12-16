package com.github.sawafrolov.fastpizza.common.entities

import com.github.sawafrolov.fastpizza.common.tables.PizzaTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import java.util.UUID

/**
 * Сущность пиццы
 */
class PizzaEntity(id: EntityID<UUID>): UUIDEntity(id) {

    /**
     * Специальный объект для Exposed ORM
     */
    companion object: UUIDEntityClass<PizzaEntity>(PizzaTable)

    /**
     * UUID
     */
    var uuid by PizzaTable.id

    /**
     * Название пиццы
     */
    var name by PizzaTable.name

    /**
     * Описание пиццы
     */
    var description by PizzaTable.description

    /**
     * Масса в граммах
     */
    var weight by PizzaTable.weight

    /**
     * Цена в рублях
     */
    var price by PizzaTable.price

    /**
     * Список ингридиентов
     */
    var ingredients by PizzaTable.ingredients

    /**
     * Дата и время создания записи (служебное поле)
     */
    var createdAt by PizzaTable.createdAt

    /**
     * Дата и время обновления записи (служебное поле)
     */
    var updatedAt by PizzaTable.updatedAt

    /**
     * Дата и время удаления записи (служебное поле)
     */
    var deletedAt by PizzaTable.deletedAt

    /**
     * Признак удаления записи (служебное поле)
     */
    var deleted by PizzaTable.deleted
}
