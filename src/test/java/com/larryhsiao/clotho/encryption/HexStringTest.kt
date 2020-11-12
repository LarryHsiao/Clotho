package com.larryhsiao.clotho.encryption

import org.junit.Assert.assertEquals
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
            HexString("ABC".toByteArray()).value()
        )
    }
}