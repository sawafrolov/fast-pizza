package com.github.sawafrolov.fastpizza.common.util

import com.github.sawafrolov.fastpizza.common.dto.customer.CustomerShortDto
import java.util.UUID

class ObjectUtil {

    companion object {

        private val uuid = UUID.fromString("8f5581c2-5311-450c-9043-a0f03f0a3142")

        private val email = "test@test.com"

        val correctCustomerShortDto = CustomerShortDto(
            uuid = uuid,
            email = email
        )
    }
}
