package com.larryhsiao.clotho.date

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Calendar.*

/**
 * Tests for [DateCalendar]
 */
class DateCalendarTest {

    /**
     * Check result
     */
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