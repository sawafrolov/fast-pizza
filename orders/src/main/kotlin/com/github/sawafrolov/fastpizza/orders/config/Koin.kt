package com.github.sawafrolov.fastpizza.orders.config

import com.github.sawafrolov.fastpizza.common.util.validation.parameterMessageInterpolator
import com.github.sawafrolov.fastpizza.common.util.validation.validator
import com.github.sawafrolov.fastpizza.orders.mappers.CustomerMapper
import com.github.sawafrolov.fastpizza.orders.mappers.OrderMapper
import com.github.sawafrolov.fastpizza.orders.mappers.PizzaMapper
import com.github.sawafrolov.fastpizza.orders.mappers.impl.CustomerMapperImpl
import com.github.sawafrolov.fastpizza.orders.mappers.impl.OrderMapperImpl
import com.github.sawafrolov.fastpizza.orders.mappers.impl.PizzaMapperImpl
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

    singleOf(::OrderMapperImpl) {
        bind<OrderMapper>()
    }

    singleOf(::PizzaMapperImpl) {
        bind<PizzaMapper>()
    }
}

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(beans)
    }
}
