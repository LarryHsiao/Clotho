package com.larryhsiao.clotho.connection

import com.larryhsiao.clotho.regex.IsIPv4
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Tests for [com.larryhsiao.clotho.connection.IPv4Mapping]
 */
class IPv4MappingTest {
    /**
     * Check the output
     */
    @Test
    fun simple() {
        assertNotEquals(
            0,
            IPv4Mapping().value().size
        )
    }

    /**
     * Check all result is IPv4
     */
    @Test
    fun checkIPv4() {
        IPv4Mapping().value().forEach {
            assertTrue(IsIPv4(it.value.hostAddress).value())
        }
    }
}