package com.silverhetch.clotho.utility.color

import org.junit.Assert.*
import org.junit.Test

class RedIntTest {
    @Test
    fun simple() {
        assertEquals(
            160,
            RedInt(0xA0FFFF).value()
        )
    }
}