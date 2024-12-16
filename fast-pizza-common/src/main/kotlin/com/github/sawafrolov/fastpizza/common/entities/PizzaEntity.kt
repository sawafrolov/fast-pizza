package com.github.sawafrolov.fastpizza.common.entities

import com.github.sawafrolov.fastpizza.common.tables.PizzaTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.UUIDEntity
import java.util.UUID

/**
 * Сущность пиццы
 */
class PizzaEntity(id: EntityID<UUID>): UUIDEntity(id) {

    /**
     * Специальный объект для Exposed ORM
     */
    companion object: EntityClass<UUID, PizzaEntity>(PizzaTable)

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
    var created_at by PizzaTable.created_at

    /**
     * Дата и время обновления записи (служебное поле)
     */
    var updated_at by PizzaTable.updated_at

    /**
     * Дата и время удаления записи (служебное поле)
     */
    var deleted_at by PizzaTable.deleted_at

    /**
     * Признак удаления записи (служебное поле)
     */
    var deleted by PizzaTable.deleted
}
