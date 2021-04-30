package com.larryhsiao.clotho.color

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LuminanceByColorTest {
    @Test
    fun white() {
        assertEquals(
            1.0,
            LuminanceByColor(0xFFFFFF).value(),
            0.0
        )
    }

    @Test
    fun black() {
        assertEquals(
            0.0,
            LuminanceByColor(0x000000).value(),
            0.0
        )
    }

    /**
     * Check Color(127,127,127), the luminance should be 0.4980(255/127)
     */
    @Test
    fun color_7f7f7f() {
        assertEquals(
            0.4980,
            LuminanceByColor(0x7f7f7f).value(),
            0.0001
        )
    }
}