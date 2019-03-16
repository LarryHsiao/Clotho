package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * HmacSHA1 Encode with given data and secret.
 */
class HmacSHA1(private val data: Source<ByteArray>, private val secret: String) : Source<ByteArray> {
    override fun value(): ByteArray {
        val signingKey = SecretKeySpec(secret.toByteArray(Charsets.UTF_8), "HmacSHA1")
        val mac = Mac.getInstance("HmacSHA1")
        mac.init(signingKey)
        return mac.doFinal(data.value())
    }
}