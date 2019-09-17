package com.silverhetch.clotho.time

import com.silverhetch.clotho.Source
import java.util.*

/**
 * Convert local timestamp to UTC one.
 */
class ToUTCTimestamp(private val localeTimestamp: Long) : Source<Long> {
    override fun value(): Long {
        return Calendar.getInstance().also {
            it.clear()
            it.timeInMillis = localeTimestamp
            it.timeZone = TimeZone.getTimeZone("UTC")
        }.timeInMillis
    }
}