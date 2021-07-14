package com.larryhsiao.clotho.date

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Calendar.*

/**
 * Tests for [DateCalendar]
 */
class DateCalendarTest {
    /**
     * Check result
     */
    @Test
    fun checkByCalendarObj() {
        DateCalendar(
            0,
            getInstance()
        ).value().also {
            assertEquals(0, it.get(HOUR_OF_DAY))
            assertEquals(0, it.get(MINUTE))
            assertEquals(0, it.get(SECOND))
        }
    }

    /**
     * Check by milliseconds
     */
    @Test
    fun checkByMillis() {
        val result = DateCalendar(1626287731000, getInstance()).value()
        assertEquals(1626278400000, result.timeInMillis)
    }
}