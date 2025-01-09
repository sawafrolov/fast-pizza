package com.github.sawafrolov.fastpizza.orders.mappers.impl

import com.github.sawafrolov.fastpizza.common.dto.order.OrderCreateDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderStatus
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.entities.CustomerEntity
import com.github.sawafrolov.fastpizza.common.entities.OrderEntity
import com.github.sawafrolov.fastpizza.common.entities.PizzaEntity
import com.github.sawafrolov.fastpizza.common.tables.CustomerTable
import com.github.sawafrolov.fastpizza.orders.mappers.CustomerMapper
import com.github.sawafrolov.fastpizza.orders.mappers.OrderMapper
import com.github.sawafrolov.fastpizza.orders.mappers.PizzaMapper
import org.jetbrains.exposed.dao.id.EntityID

class OrderMapperImpl(
    private val customerMapper: CustomerMapper,
    private val pizzaMapper: PizzaMapper
): OrderMapper {

    override fun mapToEntity(orderCreateDto: OrderCreateDto): OrderEntity =
        OrderEntity.new {
            customer = EntityID(orderCreateDto.customerId, CustomerTable)
            cast = orderCreateDto.cast
            address = orderCreateDto.address
            totalWeight = orderCreateDto.totalWeight
            totalPrice = orderCreateDto.totalPrice
            status = "ACCEPTED"
        }
    
    override fun mapToViewDto(
        orderEntity: OrderEntity,
        customerEntity: CustomerEntity,
        pizzaEntities: List<PizzaEntity>
    ): OrderViewDto =
        OrderViewDto(
            uuid = orderEntity.uuid.value,
            customer = customerMapper.mapToShortDto(customerEntity),
            cast = pizzaEntities.map(pizzaMapper::mapToShortDto),
            address = orderEntity.address,
            totalWeight = orderEntity.totalWeight,
            totalPrice = orderEntity.totalPrice,
            status = OrderStatus.valueOf(orderEntity.status)
        )
}
