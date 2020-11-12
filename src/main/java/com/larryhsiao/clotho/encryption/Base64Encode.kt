package com.larryhsiao.clotho.encryption

import com.larryhsiao.clotho.Source
import java.util.*

/**
 * Encode given ByteArray to Base64 String.
 */
class Base64Encode(private val data: Source<ByteArray>) : Source<String> {
    override fun value(): String {
        return Base64.getEncoder().encodeToString(data.value())
    }
}