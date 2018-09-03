package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import org.junit.Assert.*
import org.junit.Test

class HexStringTest {
    @Test
    fun simple() {
        assertEquals(
            "414243",
            HexString(
                object : Source<ByteArray> {
                    override fun fetch(): ByteArray {
                        return "ABC".toByteArray()
                    }
                }
            ).fetch()
        )
    }
}