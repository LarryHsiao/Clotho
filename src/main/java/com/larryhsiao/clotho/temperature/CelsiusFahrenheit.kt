package com.larryhsiao.clotho.temperature

import com.larryhsiao.clotho.Source

/**
 * Source to build a Fahrenheit from Celsius
 */
class CelsiusFahrenheit(private val celsius: Float) : Source<Float> {
    override fun value(): Float {
        return (celsius * 9 / 5) + 32
    }
}