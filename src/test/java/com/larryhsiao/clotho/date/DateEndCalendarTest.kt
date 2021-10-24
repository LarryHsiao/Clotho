package com.larryhsiao.clotho.date

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Calendar.*

/**
 * Tests for [DateEndCalendar]
 */
class DateEndCalendarTest {
    /**
     * Check result
     */
    @Test
    fun checkByCalendarObj() {
        DateEndCalendar(
            0,
            getInstance()
        ).value().also {
            assertEquals(23, it.get(HOUR_OF_DAY))
            assertEquals(59, it.get(MINUTE))
            assertEquals(59, it.get(SECOND))
        }
    }

    /**
     * Check by milliseconds
     */
    @Test
    fun checkByMillis() {
        val result = DateEndCalendar(1626287731000, getInstance()).value()
        assertEquals(1626364799999, result.timeInMillis)
    }
}