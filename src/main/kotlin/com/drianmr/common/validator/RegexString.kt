package com.drianmr.common.validator

/**
 * A class representing a validator for strings that must match a specific regular expression.
 *
 * This class validates that the provided string adheres to the defined [regex] pattern.
 *
 * @param regex The [Regex] object defining the regular expression pattern the string must match.
 */
data class RegexString(val regex: Regex) : FieldValidator<String?> {

    companion object {

        val Email =
            RegexString("^[a-zA-Z0-9.!#\$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\$")
    }

    constructor(pattern: String) : this(pattern.toRegex())

    override fun validate(value: String?): Boolean = regex.matches(value ?: "")
}
