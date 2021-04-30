package com.larryhsiao.clotho.color

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Test for [GreenInt]
 */
class GreenIntTest {
    @Test
    fun simple() {
        assertEquals(
            160,
            GreenInt(0xFFA0FF).value()
        )
    }
}