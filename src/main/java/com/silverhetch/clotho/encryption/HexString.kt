package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import java.util.*
import javax.xml.bind.DatatypeConverter

/**
 * Convert to hex from given data.
 */
class HexString(private val bytes: ByteArray) : Source<String> {
    override fun value(): String {
        return DatatypeConverter.printHexBinary(bytes)
    }
}