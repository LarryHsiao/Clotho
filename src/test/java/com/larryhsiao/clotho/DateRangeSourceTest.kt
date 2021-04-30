package com.larryhsiao.clotho

import com.larryhsiao.clotho.date.DateRangeSource
import com.larryhsiao.clotho.source.ConstSource

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

/**
 * DateRange test
 */
class DateRangeSourceTest {

    /**
     * Test if the result range is covert the entire day
     */
    @Test
    fun simple() {
        DateRangeSource(
            TimeZone.getTimeZone("GMT"),
            ConstSource(Pair(0L, 0L)) // 1970/01/02 00:00:00
        ).value().run {
            assertEquals("1970-01-01T23:59:59Z", Date(first).toInstant().toString())
            assertEquals("1970-01-01T00:00:00Z", Date(second).toInstant().toString())
        }
    }
}