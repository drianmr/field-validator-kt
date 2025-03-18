package com.drianmr.common.validator

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * A class representing a validator for present or future dates.
 */
data object PresentOrFutureDate : FieldValidator<LocalDate> {

    override fun validate(value: LocalDate): Boolean =
        value >= Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
}
