package com.silverhetch.clotho.utility.color

import com.silverhetch.clotho.Source

/**
 * Extract red int in color int
 */
class RedInt(private val color:Long) : Source<Long> {
    override fun value(): Long {
        return color.shr( 16) and 0xff
    }
}