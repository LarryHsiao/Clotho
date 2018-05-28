package com.silverhetch.elizabeth.encryption

import com.silverhetch.elizabeth.Pipeline
import java.util.*

/**
 * Encode given ByteArray to Base64 String.
 */
class Base64Encode(private val data: Pipeline<ByteArray>) : Pipeline<String> {
    override fun compute(): String {
        return Base64.getEncoder().encodeToString(data.compute())
    }
}