package com.larryhsiao.clotho.regex

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Tests for [com.larryhsiao.clotho.regex.IsIPv4]
 */
class IsIPv4Test {
    /**
     * Check the output
     */
    @Test
    fun simple() {
        assertTrue(IsIPv4("0.0.0.0").value())
        assertTrue(IsIPv4("100.100.100.100").value())
        assertFalse(IsIPv4("100.100.100.256").value())
    }
}