package com.drianmr.common.validator

/**
 * A class representing a validator for required string fields.
 *
 * This class ensures that the provided string value is not null or blank.
 */
data object RequiredString : FieldValidator<String?> {

    override fun validate(value: String?): Boolean = !value.isNullOrBlank()
}
