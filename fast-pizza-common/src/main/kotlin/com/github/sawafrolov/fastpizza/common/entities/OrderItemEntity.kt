package com.github.sawafrolov.fastpizza.common.entities

import com.github.sawafrolov.fastpizza.common.tables.OrderItemTable
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

/**
 * Сущность OrderItem
 */
class OrderItemEntity(id: EntityID<UUID>): UUIDEntity(id) {

    /**
     * Специальный объект для Exposed ORM
     */
    companion object: UUIDEntityClass<OrderItemEntity>(OrderItemTable)

    /**
     * UUID
     */
    var uuid by OrderItemTable.id

    /**
     * Заказ
     */
    var order by OrderEntity referencedOn OrderItemTable.orderId

    /**
     * Пицца
     */
    var pizza by PizzaEntity referencedOn OrderItemTable.pizzaId

    /**
     * Количество
     */
    var quantity by OrderItemTable.quantity

    /**
     * Дата и время создания записи (служебное поле)
     */
    var createdAt by OrderItemTable.createdAt

    /**
     * Дата и время обновления записи (служебное поле)
     */
    var updatedAt by OrderItemTable.updatedAt

    /**
     * Дата и время удаления записи (служебное поле)
     */
    var deletedAt by OrderItemTable.deletedAt

    /**
     * Признак удаления записи (служебное поле)
     */
    var deleted by OrderItemTable.deleted
}
