package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import java.util.*

/**
 * Convert to hex from given data.
 */
class HexString(private val bytes: ByteArray) : Source<String> {
    override fun value(): String {
        with(Formatter()) {
            for (byte in bytes) {
                format("%02x", byte)
            }

            return toString()
        }
    }
}