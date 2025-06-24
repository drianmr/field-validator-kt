package com.drianmr.common.validator

/**
 * An interface representing different types of field validators for a specific data type [T].
 *
 * This interface defines the contract for validating fields based on various criteria.
 * Different implementations provide specific validation logic for different field types.
 *
 * @param T The type of data the validator operates on.
 */
interface FieldValidator<T> {

    /**
     * Validates the provided [value] against the specific criteria of the implementing validator.
     *
     * This function performs the actual validation check and returns `true` if the value is valid
     * according to the validator's logic. The specific validation logic depends on the implementing class.
     *
     * @param value The value to be validated against the validator's criteria.
     * @return `true` if the value is valid, `false` otherwise.
     */
    fun validate(value: T): Boolean
}
