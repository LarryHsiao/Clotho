package com.silverhetch.clotho.utility.color

import com.silverhetch.clotho.Source

/**
 * Extract blue int in color int
 */
class BlueInt(private val color: Long) : Source<Long> {
    override fun value(): Long {
        return color and 0xff
    }
}