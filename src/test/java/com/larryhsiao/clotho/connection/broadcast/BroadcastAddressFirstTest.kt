package com.larryhsiao.clotho.connection.broadcast

import org.junit.Assert.assertNotNull
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