package com.silverhetch.clotho.regex

import com.silverhetch.clotho.Source

/**
 * Check if given string is mail.
 */
class IsMail(private val input: String) : Source<Boolean> {
    override fun value(): Boolean {
        return Regex("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]\$").matches(input)
    }
}