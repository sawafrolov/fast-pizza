package com.github.sawafrolov.fastpizza.iamproxy.config

import com.github.sawafrolov.fastpizza.common.util.validation.validator
import com.github.sawafrolov.fastpizza.iamproxy.services.FakeIamService
import com.github.sawafrolov.fastpizza.iamproxy.services.IamService
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
