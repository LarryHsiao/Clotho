package com.silverhetch.clotho.date

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar.*

/**
 * Tests for [DateCalendar]
 */
class DateCalendarTest {

    /**
     * Check result
     */
    @Test
    fun simple() {
        DateCalendar(
            0,
            getInstance()
        ).value().also {
            assertEquals(0, it.get(HOUR_OF_DAY))
            assertEquals(0, it.get(MINUTE))
            assertEquals(0, it.get(SECOND))
        }
    }
}