package com.github.sawafrolov.fastpizza.pizza.config

import com.github.sawafrolov.fastpizza.common.mappers.PizzaMapper
import com.github.sawafrolov.fastpizza.common.mappers.impl.PizzaMapperImpl
import com.github.sawafrolov.fastpizza.common.util.validation.validator
import com.github.sawafrolov.fastpizza.pizza.services.PizzaService
import com.github.sawafrolov.fastpizza.pizza.services.FakePizzaService
import io.ktor.server.application.*
import jakarta.validation.Validator
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val beans = module {
    single<Validator> {
        validator()
    }

    singleOf(::PizzaMapperImpl) {
        bind<PizzaMapper>()
    }

    singleOf(::FakePizzaService) {
        bind<PizzaService>()
    }
}

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(beans)
    }
}
