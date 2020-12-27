package com.larryhsiao.clotho.encryption

import com.larryhsiao.clotho.dgist.HexString
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Test for [HexString].
 */
class HexStringTest {
    /**
     * Check the hex result.
     */
    @Test
    fun simple() {
        assertEquals(
            "414243",
            HexString("ABC".toByteArray()).value()
        )
    }
}