package com.github.sawafrolov.fastpizza.common.util

import com.github.sawafrolov.fastpizza.common.validation.parameterMessageInterpolator
import com.github.sawafrolov.fastpizza.common.validation.validator

class ValidationUtil {

    companion object {

        private val validator = validator(parameterMessageInterpolator())

        fun isValid(obj: Any) =
            validator.validate(obj).isEmpty()
    }
}
