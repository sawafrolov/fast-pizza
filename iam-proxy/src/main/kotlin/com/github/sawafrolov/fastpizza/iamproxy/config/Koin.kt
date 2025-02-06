package com.github.sawafrolov.fastpizza.iamproxy.config

import com.github.sawafrolov.fastpizza.iamproxy.services.FakeIamService
import com.github.sawafrolov.fastpizza.iamproxy.services.IamService
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

    singleOf(::FakeIamService) {
        bind<IamService>()
    }
}

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(beans)
    }
}
