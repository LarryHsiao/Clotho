package com.silverhetch.clotho.connection.broadcast

import org.junit.Assert.*
import org.junit.Test

/**
 * Test for [BroadcastAddressCp]
 */
class BroadcastAddressCpTest {
    @Test
    fun simple() {
        BroadcastAddressCp().value().run {
            assertTrue(size > 0)
        }
    }
}