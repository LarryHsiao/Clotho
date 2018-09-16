package com.silverhetch.clotho.utility.comparator

import org.junit.Assert.*
import org.junit.Test

class StringComparatorTest {
    @Test
    fun checkEqual() {
        assertEquals(
            0,
            StringComparator().compare("1", "1")
        )
    }

    @Test
    fun simple() {
        assertEquals(
            1,
            StringComparator().compare("1", "2")
        )
    }

    @Test
    fun simple_reversed() {
        assertEquals(
            -1,
            StringComparator(true).compare("1", "2")
        )
    }
}