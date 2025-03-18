package com.drianmr.common.validator

/**
 * A class representing a validator for strings with a minimum length requirement.
 *
 * This class validates that the provided string's length is greater than or equal
 * to the specified [min] value.
 *
 * @param min The minimum allowed length for the string.
 */
data class MinimumLengthString(val min: Int) : FieldValidator<String?> {

    override fun validate(value: String?): Boolean = (value?.length ?: 0) >= min
}
