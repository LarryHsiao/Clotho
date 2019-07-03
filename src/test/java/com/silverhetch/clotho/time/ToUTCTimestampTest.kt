package com.silverhetch.clotho.time

import org.junit.Assert.*
import org.junit.Test
import java.util.*

/**
 * Test for [ToUTCTimestamp]
 */
class ToUTCTimestampTest {
    /**
     * Check if the converted UTC time is same as system provided UTC time. (tolerance: 1 second)
     */
    @Test
    fun asia_taipei() {
        assertEquals(
            Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000,
            ToUTCTimestamp(
                Calendar.getInstance(TimeZone.getTimeZone("Asia/Taipei")).timeInMillis
            ).value() / 1000
        )
    }
}