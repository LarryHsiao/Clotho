package com.larryhsiao.clotho.temperature

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit-test for the class [FahrenheitCelsius]
 */
class FahrenheitCelsiusTest {

    /**
     * Check input/output
     */
    @Test
    fun simple() {
        assertEquals(0f, FahrenheitCelsius(32f).value())
        assertEquals(100f, FahrenheitCelsius(212f).value())
    }
}