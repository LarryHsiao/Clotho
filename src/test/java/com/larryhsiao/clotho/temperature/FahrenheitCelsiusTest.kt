package com.larryhsiao.clotho.temperature

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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