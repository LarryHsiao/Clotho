package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class HmacSHA1(private val data: Source<String>, private val secret: String) : Source<ByteArray> {
    override fun fetch(): ByteArray {
        val signingKey = SecretKeySpec(secret.toByteArray(Charsets.UTF_8), "HmacSHA1")
        val mac = Mac.getInstance("HmacSHA1")
        mac.init(signingKey)
        return mac.doFinal(data.fetch().toByteArray())
    }
}