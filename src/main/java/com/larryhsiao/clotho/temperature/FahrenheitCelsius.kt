package com.larryhsiao.clotho.temperature

import com.larryhsiao.clotho.Source

/**
 * Build a Celsius value from a given Fahrenheit
 */
class FahrenheitCelsius(private val fahrenheit: Float) : Source<Float> {
    override fun value(): Float {
        return (fahrenheit - 32) * 5 / 9
    }
}