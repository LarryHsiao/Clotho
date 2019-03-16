package com.silverhetch.clotho.date

import com.silverhetch.clotho.Source
import java.util.*

class DateCalendar(private val millis: Long) : Source<Calendar> {
    override fun value(): Calendar {
        return Calendar.getInstance().apply {
            timeInMillis = millis
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
    }
}