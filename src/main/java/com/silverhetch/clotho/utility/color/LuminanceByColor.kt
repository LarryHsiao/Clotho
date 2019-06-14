package com.silverhetch.clotho.utility.color

import com.silverhetch.clotho.Source

/**
 * Calculate the Luminance of color.
 *
 * Calculate by formula CCIR 601(ITU-R Recommendation BT.601)
 */
class LuminanceByColor(private val color: Long) : Source<Double> {
    /**
     * The luminance is between 1.0-0.0, lightest is 1.0, otherwise 0.0
     */
    override fun value(): Double {
        return (0.299 * RedInt(color).value()
            + 0.587 * GreenInt(color).value()
            + 0.114 * BlueInt(color).value()) / 255
    }
}
