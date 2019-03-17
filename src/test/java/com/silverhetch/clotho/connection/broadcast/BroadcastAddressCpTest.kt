package com.silverhetch.clotho.connection.broadcast

import org.junit.Assert.*
import org.junit.Test

class BroadcastAddressCpTest {
    @Test
    fun simple() {
        BroadcastAddressCp().value().run {
            assertTrue(size > 0)
        }
    }
}