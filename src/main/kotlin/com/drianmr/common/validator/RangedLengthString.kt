package com.drianmr.common.validator

/**
 * A class representing a validator for strings within a specific length range.
 *
 * This class validates that the provided string's length falls within the specified [range].
 *
 * @param range The [IntRange] object defining the minimum and maximum allowed length for the string.
 */
data class RangedLengthString(val range: IntRange) : FieldValidator<String?> {

    override fun validate(value: String?): Boolean = (value?.length ?: 0) in range
}
