package com.kotlin.sample.web.common

import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField

object DateFormatterFactory {
    fun dateTimeFormatter(): DateTimeFormatter {
        return DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
            .appendPattern("'+09:00'")
            .toFormatter()
    }

    fun dateFormatter(): DateTimeFormatter {
        return DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd")
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .toFormatter()
    }

    fun timeFormatter(): DateTimeFormatter {
        return DateTimeFormatterBuilder()
            .appendPattern("HH:mm")
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .toFormatter()
    }
}
