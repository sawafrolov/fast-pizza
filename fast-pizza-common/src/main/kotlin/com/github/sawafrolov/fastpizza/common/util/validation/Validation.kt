package com.github.sawafrolov.fastpizza.common.util.validation

import jakarta.validation.Validation
import jakarta.validation.Validator
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator

fun parameterMessageInterpolator(): ParameterMessageInterpolator =
    ParameterMessageInterpolator()

fun validator(parameterMessageInterpolator: ParameterMessageInterpolator): Validator =
    Validation
        .byDefaultProvider()
        .configure()
        .messageInterpolator(parameterMessageInterpolator)
        .buildValidatorFactory()
        .validator
