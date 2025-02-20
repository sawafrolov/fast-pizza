package com.github.sawafrolov.fastpizza.common.dto

import java.util.UUID

data class PizzaDeleteDto(
    var uuid: UUID,
    var lock: String
)
