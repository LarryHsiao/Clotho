package com.larryhsiao.clotho.connection.broadcast

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

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