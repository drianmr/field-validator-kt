package com.drianmr.common.validator

/**
 * A class that performs field validation for a given value [T] using a set of [validator].
 *
 * This class provides a convenient way to chain multiple validators for a specific field value.
 * It takes the value to be validated [value], a callback function [onInvalid]
 * to be executed if any validation fails, and a variable number of [validator]
 * extending the [FieldValidator] interface.
 *
 * @param T The type of the data field being validated.
 * @param V A subtype of [FieldValidator] representing the specific validator type used.
 * @param value The value to be validated against the provided validators.
 * @param onInvalid A callback function that is executed if any validation fails.
 * It receives the failing validator as an argument.
 */
class FieldValidation<T, V : FieldValidator<T>>(
    private val value: T,
    private vararg val validator: V,
    private val onInvalid: (validator: V) -> Unit,
) {

    /**
     * Performs the validation for the provided value against all the registered validators.
     *
     * This function iterates through each [validator] and calls its [validate] method with the [value].
     * If any validation fails (returns `false`), the [onInvalid] callback is invoked with the failing validator.
     * The loop breaks after the first validation failure to prevent unnecessary checks.
     */
    fun validate() {
        for (validator in validator) {
            if (!validator.validate(value)) {
                onInvalid(validator)
                break
            }
        }
    }
}
