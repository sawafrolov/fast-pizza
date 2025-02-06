package com.github.sawafrolov.fastpizza.customers.config

import com.github.sawafrolov.fastpizza.common.mappers.CustomerMapper
import com.github.sawafrolov.fastpizza.common.mappers.impl.CustomerMapperImpl
import com.github.sawafrolov.fastpizza.customers.services.CustomerService
import com.github.sawafrolov.fastpizza.customers.services.FakeCustomerService
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

    singleOf(::FakeCustomerService) {
        bind<CustomerService>()
    }
}

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(beans)
    }
}
