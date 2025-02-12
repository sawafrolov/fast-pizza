package com.github.sawafrolov.fastpizza.common.util.test

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerUpdateDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import com.github.sawafrolov.fastpizza.common.dto.iam.ChangePasswordDto
import com.github.sawafrolov.fastpizza.common.dto.iam.LoginDto
import com.github.sawafrolov.fastpizza.common.dto.iam.RegistrationDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderChangeStatusDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderCreateDto
import com.github.sawafrolov.fastpizza.common.dto.order.OrderStatus
import com.github.sawafrolov.fastpizza.common.dto.order.OrderViewDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaCreateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaShortDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaUpdateDto
import com.github.sawafrolov.fastpizza.common.dto.pizza.PizzaViewDto
import java.math.BigDecimal
import java.util.UUID

private val uuid = UUID.fromString("8f5581c2-5311-450c-9043-a0f03f0a3142")
private val customerId = UUID.fromString("8f5581c2-5311-450c-9043-a0f03f0a3142")
private val pizzaId = UUID.fromString("8f5581c2-5311-4d0c-8a43-a0f03f0a3142")
private val smallPizzaId = UUID.fromString("8f5581c2-5311-4d0c-8a43-a0f03fe20842")

private const val email = "test@test.com"
private const val password = "password"
private const val newPassword = "newPassword"
private const val phoneNumber = "1234567890"
private const val patronymic = "Patronymic"
private val addresses = listOf("TestAddress1", "TestAddress2")

private const val test = "Test"
private const val testAddress1 = "TestAddress1"
private const val testPizza = "Test Pizza"
private const val testPizzaDescription = "Test Pizza Description"
private const val smallPizza = "Small Pizza"

private const val pizzaWeight = 345
private val pizzaPrice = BigDecimal("600.00")
private val ingredients = listOf("Cheese", "Tomatoes")

private const val orderWeight = 1234
private val orderPrice = BigDecimal("1499.00")
private val orderStatus = OrderStatus.FINISHED

val correctChangePasswordDto = ChangePasswordDto(
    email = email,
    password = password,
    newPassword = newPassword
)

val correctLoginDto = LoginDto(
    email = email,
    password = password
)

val correctRegistrationDto = RegistrationDto(
    email = email,
    password = password,
    phoneNumber = null,
    firstName = null
)

val fullRegistrationDto = RegistrationDto(
    email = email,
    password = password,
    phoneNumber = phoneNumber,
    firstName = test
)

val correctCustomerShortDto = CustomerShortDto(
    uuid = uuid,
    email = email
)

val correctCustomerUpdateDto = CustomerUpdateDto(
    uuid = uuid,
    phoneNumber = phoneNumber,
    firstName = test,
    lastName = null,
    patronymic = null
)

val fullCustomerUpdateDto = CustomerUpdateDto(
    uuid = uuid,
    phoneNumber = phoneNumber,
    firstName = test,
    lastName = test,
    patronymic = patronymic
)

val correctCustomerViewDto = CustomerViewDto(
    uuid = uuid,
    email = email,
    phoneNumber = phoneNumber,
    firstName = test,
    lastName = null,
    patronymic = null,
    addresses = null,
    pizzas = null
)

val correctOrderChangeStatusDto = OrderChangeStatusDto(
    uuid = uuid,
    status = OrderStatus.FINISHED
)

val correctOrderCreateDto = OrderCreateDto(
    customerId = customerId,
    cart = listOf(pizzaId, pizzaId, smallPizzaId),
    address = testAddress1,
    totalWeight = orderWeight,
    totalPrice = orderPrice
)

val correctOrderViewDto = OrderViewDto(
    uuid = uuid,
    customer = CustomerShortDto(customerId, email),
    cart = listOf(
        PizzaShortDto(pizzaId, testPizza),
        PizzaShortDto(pizzaId, testPizza),
        PizzaShortDto(smallPizzaId, smallPizza)
    ),
    address = testAddress1,
    totalWeight = orderWeight,
    totalPrice = orderPrice,
    status = orderStatus
)

val correctPizzaCreateDto = PizzaCreateDto(
    name = testPizza,
    description = null,
    weight = pizzaWeight,
    price = pizzaPrice,
    ingredients = ingredients
)

val fullPizzaCreateDto = PizzaCreateDto(
    name = testPizza,
    description = testPizzaDescription,
    weight = pizzaWeight,
    price = pizzaPrice,
    ingredients = ingredients
)

val correctPizzaShortDto = PizzaShortDto(
    uuid = uuid,
    name = testPizza
)

val correctPizzaUpdateDto = PizzaUpdateDto(
    uuid = uuid,
    description = null,
    weight = pizzaWeight,
    price = pizzaPrice,
    ingredients = ingredients
)

val fullPizzaUpdateDto = PizzaUpdateDto(
    uuid = uuid,
    description = testPizzaDescription,
    weight = pizzaWeight,
    price = pizzaPrice,
    ingredients = ingredients
)

val correctPizzaViewDto = PizzaViewDto(
    uuid = uuid,
    name = testPizza,
    description = null,
    weight = pizzaWeight,
    price = pizzaPrice,
    ingredients = ingredients
)

val fullPizzaViewDto = PizzaViewDto(
    uuid = uuid,
    name = testPizza,
    description = testPizzaDescription,
    weight = pizzaWeight,
    price = pizzaPrice,
    ingredients = ingredients
)

val fullCustomerViewDto = CustomerViewDto(
    uuid = uuid,
    email = email,
    phoneNumber = phoneNumber,
    firstName = test,
    lastName = test,
    patronymic = patronymic,
    addresses = addresses,
    pizzas = mapOf(
        pizzaId.toString() to 2,
        smallPizzaId.toString() to 1
    )
)
