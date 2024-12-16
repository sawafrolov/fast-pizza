package com.github.sawafrolov.fastpizza.common.entities

import com.github.sawafrolov.fastpizza.common.tables.OrderTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

/**
 * Сущность заказа
 */
class OrderEntity(id: EntityID<UUID>): UUIDEntity(id) {

    /**
     * Специальный объект для Exposed ORM
     */
    companion object: UUIDEntityClass<OrderEntity>(OrderTable)

    /**
     * UUID
     */
    var uuid by OrderTable.id

    /**
     * Пользователь
     */
    var customer by CustomerEntity referencedOn OrderTable.customer

    /**
     * Суммарная масса заказа в граммах
     */
    var totalWeight by OrderTable.totalWeight

    /**
     * Суммарная стоимость заказа в рублях
     */
    var totalPrice by OrderTable.totalPrice

    /**
     * Дата и время создания записи (служебное поле)
     */
    var createdAt by OrderTable.createdAt

    /**
     * Дата и время обновления записи (служебное поле)
     */
    var updatedAt by OrderTable.updatedAt

    /**
     * Дата и время удаления записи (служебное поле)
     */
    var deletedAt by OrderTable.deletedAt

    /**
     * Признак удаления записи (служебное поле)
     */
    var deleted by OrderTable.deleted
}
