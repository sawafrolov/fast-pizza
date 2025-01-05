package com.github.sawafrolov.fastpizza.common.util

import jakarta.validation.Validation
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator

class ValidationUtil {

    companion object {

        private val validator = Validation
            .byDefaultProvider()
            .configure()
            .messageInterpolator(ParameterMessageInterpolator())
            .buildValidatorFactory()
            .getValidator()

        fun isValid(obj: Any) =
            validator.validate(obj).isEmpty()
    }
}
