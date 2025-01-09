package com.github.sawafrolov.fastpizza.orders.config

import com.github.sawafrolov.fastpizza.orders.mappers.CustomerMapper
import com.github.sawafrolov.fastpizza.orders.mappers.OrderMapper
import com.github.sawafrolov.fastpizza.orders.mappers.PizzaMapper
import com.github.sawafrolov.fastpizza.orders.mappers.impl.CustomerMapperImpl
import com.github.sawafrolov.fastpizza.orders.mappers.impl.OrderMapperImpl
import com.github.sawafrolov.fastpizza.orders.mappers.impl.PizzaMapperImpl
import io.ktor.server.application.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val appModule = module {
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
        modules(appModule)
    }
}
