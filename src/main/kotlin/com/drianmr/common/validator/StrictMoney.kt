package com.drianmr.common.validator

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * A class representing a validator for BigDecimal values that ensures the given BigDecimal
 * value adheres to precision and rounding constraints.
 */
data object StrictMoney : FieldValidator<BigDecimal> {

    override fun validate(value: BigDecimal): Boolean {
        return value.setScale(2, RoundingMode.FLOOR) > BigDecimal.ZERO
    }
}
