package com.silverhetch.clotho.utility

import com.silverhetch.clotho.Source

/**
 * String source just represent content of String.
 */
class StringSource(private val content: String) : Source<String> {
    override fun value(): String {
        return content
    }
}