package com.larryhsiao.clotho.utility.color

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RedIntTest {
    @Test
    fun simple() {
        assertEquals(
            160,
            RedInt(0xA0FFFF).value()
        )
    }
}