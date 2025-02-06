package com.github.sawafrolov.fastpizza.orders.config

import com.github.sawafrolov.fastpizza.common.mappers.CustomerMapper
import com.github.sawafrolov.fastpizza.common.mappers.OrderMapper
import com.github.sawafrolov.fastpizza.common.mappers.PizzaMapper
import com.github.sawafrolov.fastpizza.common.mappers.impl.CustomerMapperImpl
import com.github.sawafrolov.fastpizza.common.mappers.impl.OrderMapperImpl
import com.github.sawafrolov.fastpizza.common.mappers.impl.PizzaMapperImpl
import com.github.sawafrolov.fastpizza.starter.parameterMessageInterpolator
import com.github.sawafrolov.fastpizza.starter.validator
import io.ktor.server.application.*
import jakarta.validation.Validator
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val beans = module {
    single<ParameterMessageInterpolator> {
        parameterMessageInterpolator()
    }

    single<Validator> {
        (parameterMessageInterpolator: ParameterMessageInterpolator) -> validator(parameterMessageInterpolator)
    }

    singleOf(::CustomerMapperImpl) {
        bind<CustomerMapper>()
    }

    singleOf(::PizzaMapperImpl) {
        bind<PizzaMapper>()
    }

    single<OrderMapper> {
        (customerMapper: CustomerMapper, pizzaMapper: PizzaMapper) -> OrderMapperImpl(customerMapper, pizzaMapper)
    }
}

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(beans)
    }
}
