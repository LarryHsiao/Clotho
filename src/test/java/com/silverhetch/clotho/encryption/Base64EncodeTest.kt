package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import org.junit.Assert.*
import org.junit.Test

class Base64EncodeTest {
    @Test
    fun simple() {
        assertEquals(
            "QUJD",
            Base64Encode(object : Source<ByteArray> {
                override fun fetch(): ByteArray {
                    return "ABC".toByteArray()
                }
            }).fetch()
        )
    }
}