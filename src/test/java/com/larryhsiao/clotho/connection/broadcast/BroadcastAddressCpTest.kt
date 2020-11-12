package com.larryhsiao.clotho.connection.broadcast

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Test for [BroadcastAddressCp]
 */
class BroadcastAddressCpTest {
    @Test
    fun simple() {
        BroadcastAddressCp().value().run {
            forEach {
                System.out.println("""
                   ${it.name()}
                   ${it.interfaceInetAddress()}
               """.trimIndent())
            }
            assertTrue(size > 0)
        }
    }
}