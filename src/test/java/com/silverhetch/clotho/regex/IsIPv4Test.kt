package com.silverhetch.clotho.regex

import org.junit.Assert.*
import org.junit.Test

/**
 * Tests for [com.silverhetch.clotho.regex.IsIPv4]
 */
class IsIPv4Test {
    /**
     * Check the output
     */
    @Test
    fun simple() {
        assertTrue("", IsIPv4("0.0.0.0").value())
        assertTrue("", IsIPv4("100.100.100.100").value())
        assertFalse("", IsIPv4("100.100.100.256").value())
    }
}