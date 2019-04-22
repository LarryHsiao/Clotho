package com.silverhetch.clotho.algorithm

import com.silverhetch.clotho.Source
import java.util.*
import java.util.Calendar.*

/**
 * Decorator to find the given date range in millisecond,
 * Just make the range to cover entire of day as possible.
 *
 * @param range The given range in milliseconds, First one is Ended Date, and the seconds one is Started date.
 */
class DateRangeSource(private val range: Source<Pair<Long, Long>>) : Source<Pair<Long, Long>> {
    override fun value(): Pair<Long, Long> {
        val value = range.value()
        return Pair(
            Calendar.getInstance(TimeZone.getTimeZone("GMT")).apply {
                time = Date(value.first)
                set(HOUR_OF_DAY, 23)
                set(MINUTE, 59)
                set(SECOND, 59)
            }.timeInMillis,
            Calendar.getInstance(TimeZone.getTimeZone("GMT")).apply {
                time = Date(value.second)
                set(HOUR_OF_DAY, 0)
                set(MINUTE, 0)
                set(SECOND, 0)
            }.timeInMillis
        )
    }
}