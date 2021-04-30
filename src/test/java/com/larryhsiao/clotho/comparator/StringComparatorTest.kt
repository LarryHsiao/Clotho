package com.larryhsiao.clotho.comparator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Test for [StringComparator]
 */
class StringComparatorTest {
    /**
     * If the string is the same
     */
    @Test
    fun checkEqual() {
        assertEquals(
            0,
            StringComparator().compare("1", "1")
        )
    }

    /**
     * If the string is not the same
     */
    @Test
    fun simple() {
        assertEquals(
            1,
            StringComparator().compare("1", "2")
        )
    }

    /**
     * Check the reserved flag.
     */
    @Test
    fun simple_reversed() {
        assertEquals(
            -1,
            StringComparator(true).compare("1", "2")
        )
    }
}