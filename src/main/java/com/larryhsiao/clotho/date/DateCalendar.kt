package com.larryhsiao.clotho.date

import com.larryhsiao.clotho.Source
import java.util.*

/**
 * Source to generate Calendar which time is 00:00 am of the given timestamp.
 */
class DateCalendar(
    private val millis: Long,
    private val calendar: Calendar = Calendar.getInstance()
) : Source<Calendar> {
    override fun value(): Calendar {
        return calendar.apply {
            timeInMillis = millis
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
    }
}