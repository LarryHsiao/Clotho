package com.silverhetch.clotho.temperature

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.round

/**
 * Unit-test for the class [KelvinFahrenheit]
 */
class KelvinFahrenheitTest {
    /**
     * Check input/output
     */
    @Test
    fun simple() {
        val result = KelvinFahrenheit(
            0f
        ).value()

        assertEquals(
            -459.67F,
            round(result * 100) / 100f
        )
    }
}