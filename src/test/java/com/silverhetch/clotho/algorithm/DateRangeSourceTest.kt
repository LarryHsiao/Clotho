package com.silverhetch.clotho.algorithm

import com.silverhetch.clotho.source.ConstSource
import org.junit.Assert.*
import org.junit.Test
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
            ConstSource(Pair(0L, 0L)) // 1970/01/02 00:00:00
        ).value().run {
            assertEquals("1970-01-01T23:59:59Z", Date(first).toInstant().toString())
            assertEquals("1970-01-01T00:00:00Z", Date(second).toInstant().toString())
        }
    }
}