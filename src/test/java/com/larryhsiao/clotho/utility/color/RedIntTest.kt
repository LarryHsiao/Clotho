package com.larryhsiao.clotho.utility.color

import org.junit.Assert.assertEquals
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