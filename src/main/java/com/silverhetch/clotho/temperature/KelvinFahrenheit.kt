package com.silverhetch.clotho.temperature

import com.silverhetch.clotho.Source

/**
 * Source to build a Fahrenheit value form Kelvin.
 */
class KelvinFahrenheit(private val kelvin: Float) : Source<Float> {
    override fun value(): Float {
        return CelsiusFahrenheit(
            KelvinCelsius(
                kelvin
            ).value()
        ).value()
    }
}