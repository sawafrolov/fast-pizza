package com.github.sawafrolov.fastpizza.orders.mappers

import com.github.sawafrolov.fastpizza.common.dto.order.OrderCreateDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity
import com.github.sawafrolov.fastpizza.common.entities.OrderEntity
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity

interface OrderMapper {

    fun mapToEntity(orderCreateDto: OrderCreateDto): OrderEntity

    fun mapToViewDto(
        orderEntity: OrderEntity,
        customerEntity: CustomerEntity,
        pizzaEntities: List<PizzaEntity>
    ): OrderViewDto
}
