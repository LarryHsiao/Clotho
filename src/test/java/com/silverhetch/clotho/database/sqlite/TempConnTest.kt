package com.silverhetch.clotho.database.sqlite

import org.junit.Assert.*
import org.junit.Test

/**
 * Test for [TempConn]
 */
class TempConnTest {
    /**
     * Check the connection.
     */
    @Test
    fun simple() {
        TempConn().value().use {
            assertTrue(it.isValid(0))
        }
    }
}