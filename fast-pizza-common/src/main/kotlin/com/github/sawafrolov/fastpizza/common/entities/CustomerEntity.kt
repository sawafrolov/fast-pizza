package com.github.sawafrolov.fastpizza.common.entities

import com.github.sawafrolov.fastpizza.common.tables.CustomerTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import java.util.UUID

/**
 * Сущность пользователя
 */
class CustomerEntity(id: EntityID<UUID>): UUIDEntity(id) {

    /**
     * Специальный объект для Exposed ORM
     */
    companion object: UUIDEntityClass<CustomerEntity>(CustomerTable)

    /**
     * UUID
     */
    var uuid by CustomerTable.id

    /**
     * Адрес электронной почты
     */
    var email by CustomerTable.email

    /**
     * Пароль
     */
    var password by CustomerTable.password

    /**
     * Номер телефона
     */
    var phoneNumber by CustomerTable.phoneNumber

    /**
     * Имя
     */
    var firstName by CustomerTable.firstName

    /**
     * Фамилия
     */
    var lastName by CustomerTable.lastName

    /**
     * Отчество
     */
    var patronymic by CustomerTable.patronymic

    /**
     * Список адресов
     */
    var addresses by CustomerTable.addresses

    /**
     * Список uuid заказов
     */
    val orders by CustomerTable.orders

    /**
     * Дата и время создания записи (служебное поле)
     */
    var createdAt by CustomerTable.createdAt

    /**
     * Дата и время обновления записи (служебное поле)
     */
    var updatedAt by CustomerTable.updatedAt

    /**
     * Дата и время удаления записи (служебное поле)
     */
    var deletedAt by CustomerTable.deletedAt

    /**
     * Признак удаления записи (служебное поле)
     */
    var deleted by CustomerTable.deleted
}
