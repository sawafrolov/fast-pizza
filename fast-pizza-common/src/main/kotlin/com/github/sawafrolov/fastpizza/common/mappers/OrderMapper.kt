package com.github.sawafrolov.fastpizza.common.mappers

import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity
import com.github.sawafrolov.fastpizza.common.entities.OrderEntity
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity

interface OrderMapper {

    fun mapToViewDto(
        orderEntity: OrderEntity,
        customerEntity: CustomerEntity,
        pizzaEntities: List<PizzaEntity>
    ): OrderViewDto
}
