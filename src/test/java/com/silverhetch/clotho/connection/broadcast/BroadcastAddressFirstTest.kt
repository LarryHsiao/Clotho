package com.silverhetch.clotho.connection.broadcast

import org.junit.Assert.*
import org.junit.Test

class BroadcastAddressFirstTest {
    @Test
    fun simple() {
        assertNotNull(
            BroadcastAddressFirst().value()
        )
    }
}