package com.larryhsiao.clotho.connection.broadcast

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Test for [BroadcastAddressCp]
 */
class BroadcastAddressCpTest {
    @Test
    fun simple() {
        BroadcastAddressCp().value().run {
            forEach {
                println("""
                   ${it.name()}
                   ${it.interfaceInetAddress()}
               """.trimIndent())
            }
            assertTrue(size > 0)
        }
    }
}