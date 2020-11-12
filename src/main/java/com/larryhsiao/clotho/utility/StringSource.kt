package com.larryhsiao.clotho.utility

import com.larryhsiao.clotho.Source

/**
 * String source just represent content of String.
 */
class StringSource(private val content: String) : Source<String> {
    override fun value(): String {
        return content
    }
}