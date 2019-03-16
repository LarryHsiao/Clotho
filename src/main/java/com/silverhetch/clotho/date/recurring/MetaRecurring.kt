package com.silverhetch.clotho.date.recurring

import com.silverhetch.clotho.date.DateCalendar
import java.util.*
import kotlin.collections.ArrayList

/**
 * Class calculate the total amount of event
 */
class MetaRecurring(private val meta: Meta) : Recurring {
    override fun byTheEndOf(endDate: Calendar): List<Calendar> {
        val started = DateCalendar(meta.start()).value()
        val pointer = Calendar.getInstance().apply { timeInMillis = started.timeInMillis }
        val result = ArrayList<Calendar>()
        while (endDate.timeInMillis > pointer.timeInMillis) {
            pointer.add(Calendar.DAY_OF_YEAR, 1)
            if (canBeApplied(started, pointer)) {
                result.add(Calendar.getInstance().apply { timeInMillis = pointer.timeInMillis })
            }
        }
        return result
    }

    private fun canBeApplied(started:Calendar, pointer: Calendar): Boolean {
        return (pointer.get(Calendar.DAY_OF_MONTH) == meta.day() || meta.day() == 0)
            && (pointer.get(Calendar.MONTH) == meta.month() - 1 || meta.month() == 0)
            && (pointer.get(Calendar.YEAR) == meta.year() || meta.year() == 0)
            && (pointer.get(Calendar.DAY_OF_WEEK) == meta.weekday() || meta.weekday() == 0)
            && (pointer.get(Calendar.WEEK_OF_MONTH) == meta.week() || meta.weekday() == 0)
            && (meta.interval() == 0L || (pointer.timeInMillis - started.timeInMillis) % meta.interval() == 0L )
    }
}