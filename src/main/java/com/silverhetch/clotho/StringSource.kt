package com.silverhetch.elizabeth

/**
 * String source just represent content of String.
 */
class StringSource(private val content: String) : Source<String> {
    override fun fetch(): String {
        return content
    }
}