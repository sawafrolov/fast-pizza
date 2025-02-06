package com.github.sawafrolov.fastpizza.common.mappers.impl

import com.github.sawafrolov.fastpizza.common.dto.order.OrderStatus
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity
import com.github.sawafrolov.fastpizza.common.entities.OrderEntity
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity
import com.github.sawafrolov.fastpizza.common.mappers.CustomerMapper
import com.github.sawafrolov.fastpizza.common.mappers.OrderMapper
import com.github.sawafrolov.fastpizza.common.mappers.PizzaMapper

class OrderMapperImpl(
    private val customerMapper: CustomerMapper,
    private val pizzaMapper: PizzaMapper
): OrderMapper {
    
    override fun mapToViewDto(
        orderEntity: OrderEntity,
        customerEntity: CustomerEntity,
        pizzaEntities: List<PizzaEntity>
    ): OrderViewDto =
        OrderViewDto(
            uuid = orderEntity.uuid.value,
            customer = customerMapper.mapToShortDto(customerEntity),
            cart = pizzaEntities.map(pizzaMapper::mapToShortDto),
            address = orderEntity.address,
            totalWeight = orderEntity.totalWeight,
            totalPrice = orderEntity.totalPrice,
            status = OrderStatus.valueOf(orderEntity.status)
        )
}
