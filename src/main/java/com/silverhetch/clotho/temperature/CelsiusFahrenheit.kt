package com.silverhetch.clotho.temperature

import com.silverhetch.clotho.Source

/**
 * Source to build a Fahrenheit from Celsius
 */
class CelsiusFahrenheit(private val celsius: Float) : Source<Float> {
    override fun value(): Float {
        return (celsius * 9 / 5) + 32
    }
}