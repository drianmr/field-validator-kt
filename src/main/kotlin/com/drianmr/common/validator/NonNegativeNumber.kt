package com.drianmr.common.validator

import java.math.BigDecimal
import java.math.BigInteger

/**
 * A class representing a validator for non-negative numbers.
 *
 * This validator ensures that the provided value is a number and has a value greater than or equal to zero.
 * It supports various numeric data types including [Double], [Float], [Long], [Int], [Short], [Byte],
 * [BigDecimal], and [BigInteger].
 *
 * @throws UnsupportedOperationException if the provided value is a number type not explicitly supported
 * by this validator.
 */
data object NonNegativeNumber : FieldValidator<Number> {

    override fun validate(value: Number): Boolean {
        return when (value) {
            is Double -> value >= 0.0
            is Float -> value >= 0f
            is Long -> value >= 0L
            is Int -> value >= 0
            is Short -> value >= 0
            is Byte -> value >= 0
            is BigDecimal -> value >= BigDecimal.ZERO
            is BigInteger -> value >= BigInteger.ZERO
            else -> throw UnsupportedOperationException("Number with type ${value::class.java.simpleName} currently not supported.")
        }
    }
}
