package com.drianmr.common.validator

/**
 * Performs validation on the current instance `this` of type [T] using the provided [validator].
 *
 * This function is an extension function on a generic type T. It allows you
 * to chain validations on an object of type [T] using validators extending the [FieldValidator] interface.
 * The function takes the following arguments:
 *
 * @param T The type of the object being validated.
 * @param V A subtype of [FieldValidator] representing the specific validator type used.
 * @param onInvalid A callback function that is executed if any validation fails.
 * It receives the failing validator as an argument.
 * @param validator A variable number of validators extending [FieldValidator] to be applied to the object.
 */
inline fun <reified T, reified V : FieldValidator<T>> T.validate(
    vararg validator: V,
    noinline onInvalid: (validator: V) -> Unit,
) {
    FieldValidation(value = this, validator = validator, onInvalid = onInvalid).validate()
}
