package com.github.sawafrolov.fastpizza.common.util

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerViewDto
import java.util.UUID

object ObjectUtil {

    private val uuid = UUID.fromString("8f5581c2-5311-450c-9043-a0f03f0a3142")

    private val email = "test@test.com"

    private val phoneNumber = "1234567890"

    val correctCustomerShortDto = CustomerShortDto(
        uuid = uuid,
        email = email
    )

    val correctCustomerViewDto = CustomerViewDto(
        uuid = uuid,
        email = email,
        phoneNumber = phoneNumber,
        firstName = "Test",
        lastName = null,
        patronymic = null,
        addresses = null,
        orders = null
    )
}
