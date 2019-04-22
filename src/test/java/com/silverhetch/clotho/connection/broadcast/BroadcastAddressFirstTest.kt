package com.silverhetch.clotho.connection.broadcast

import org.junit.Assert.*
import org.junit.Test

/**
 * Test for [BroadcastAddressFirst]
 */
class BroadcastAddressFirstTest {
    @Test
    fun simple() {
        assertNotNull(
            BroadcastAddressFirst().value()
        )
    }
}