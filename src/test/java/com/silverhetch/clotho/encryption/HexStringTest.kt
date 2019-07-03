package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import org.junit.Assert.*
import org.junit.Test

/**
 * Text for [HexString]
 */
class HexStringTest {
    /***
     * CHeck the hex result.
     */
    @Test
    fun simple() {
        assertEquals(
            "414243",
            HexString(
                object : Source<ByteArray> {
                    override fun value(): ByteArray {
                        return "ABC".toByteArray()
                    }
                }
            ).value()
        )
    }
}