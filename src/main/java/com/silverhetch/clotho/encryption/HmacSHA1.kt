package com.silverhetch.elizabeth.encryption

import com.silverhetch.elizabeth.Pipeline
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class HmacSHA1(private val data: Pipeline<String>, private val secret: String) : Pipeline<ByteArray> {
    override fun compute(): ByteArray {
        val signingKey = SecretKeySpec(secret.toByteArray(Charsets.UTF_8), "HmacSHA1")
        val mac = Mac.getInstance("HmacSHA1")
        mac.init(signingKey)
        return mac.doFinal(data.compute().toByteArray())
    }
}