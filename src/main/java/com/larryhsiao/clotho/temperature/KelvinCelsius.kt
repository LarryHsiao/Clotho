package com.larryhsiao.clotho.temperature

import com.larryhsiao.clotho.Source

/**
 * Source to build Celsius value from Kelvin.
 */
class KelvinCelsius(private val kelvin: Float) : Source<Float> {
    override fun value(): Float {
        return kelvin - 273.15f
    }
}