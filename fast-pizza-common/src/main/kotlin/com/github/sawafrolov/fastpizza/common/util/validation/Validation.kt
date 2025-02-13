package com.github.sawafrolov.fastpizza.common.util.validation

import jakarta.validation.Validation
import jakarta.validation.Validator
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator

fun validator(): Validator =
    Validation
        .byDefaultProvider()
        .configure()
        .messageInterpolator(ParameterMessageInterpolator())
        .buildValidatorFactory()
        .validator

fun Validator.isValid(dto: Any): Boolean =
    this.validate(dto).isEmpty()
