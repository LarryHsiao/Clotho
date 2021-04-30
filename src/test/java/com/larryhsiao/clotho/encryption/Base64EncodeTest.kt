package com.larryhsiao.clotho.encryption

import com.larryhsiao.clotho.Source
import com.larryhsiao.clotho.dgist.Base64Encode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Base64EncodeTest {
    @Test
    fun simple() {
        assertEquals(
            "QUJD",
            Base64Encode(object : Source<ByteArray> {
                override fun value(): ByteArray {
                    return "ABC".toByteArray()
                }
            }).value()
        )
    }
}