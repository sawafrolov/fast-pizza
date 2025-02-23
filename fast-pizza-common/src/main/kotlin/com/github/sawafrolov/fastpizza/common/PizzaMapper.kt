package com.github.sawafrolov.fastpizza.common

import com.github.sawafrolov.fastpizza.common.dto.IRequest
import com.github.sawafrolov.fastpizza.common.dto.IResponse

interface PizzaMapper {

    fun response(request: IRequest): IResponse
}
