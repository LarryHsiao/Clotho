package com.larryhsiao.clotho.color

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Test for [BlueInt]
 */
class BlueIntTest {
    @Test
    fun simple() {
        assertEquals(
            160,
            BlueInt(0xFFffA0).value()
        )
    }
}