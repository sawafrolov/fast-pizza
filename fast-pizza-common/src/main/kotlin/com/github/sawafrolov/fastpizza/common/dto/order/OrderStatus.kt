package com.github.sawafrolov.fastpizza.common.dto.order

/**
 * Статус выполнения заказа
 */
enum class OrderStatus {

    ACCEPTED,
    CANCELLED,
    COOKING,
    DELIVERING,
    FINISHED,
    FAILED
}
