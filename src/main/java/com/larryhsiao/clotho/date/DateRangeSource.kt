package com.larryhsiao.clotho.date

import com.larryhsiao.clotho.Source
import java.util.*
import java.util.Calendar.*

/**
 * Decorator to find the given date range in millisecond,
 * Just make the range to cover entire of day as possible.
 *
 * @param range The given range in milliseconds, First one is Ended Date, and the seconds one is Started date.
 */
class DateRangeSource(
    private val timeZone: TimeZone,
    private val range: Source<Pair<Long, Long>>
) : Source<Pair<Long, Long>> {
    override fun value(): Pair<Long, Long> {
        val value = range.value()
        return Pair(
            Calendar.getInstance(timeZone).apply {
                time = Date(value.first)
                set(HOUR_OF_DAY, 23)
                set(MINUTE, 59)
                set(SECOND, 59)
            }.timeInMillis,
            Calendar.getInstance(timeZone).apply {
                time = Date(value.second)
                set(HOUR_OF_DAY, 0)
                set(MINUTE, 0)
                set(SECOND, 0)
            }.timeInMillis
        )
    }
}