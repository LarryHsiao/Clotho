package com.silverhetch.clotho.connection

import com.silverhetch.clotho.regex.IsIPv4
import org.junit.Assert.*
import org.junit.Test

/**
 * Tests for [com.silverhetch.clotho.connection.IPv4Mapping]
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