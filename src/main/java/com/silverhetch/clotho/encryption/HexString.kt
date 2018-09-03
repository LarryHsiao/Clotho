package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import java.util.*

/**
 * Convert to hex from given data.
 */
class HexString(private val bytes: Source<ByteArray>) : Source<String> {
    override fun fetch(): String {
        with(Formatter()) {
            for (byte in bytes.fetch()) {
                format("%02x", byte)
            }

            return toString()
        }
    }
}