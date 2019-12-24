package com.silverhetch.clotho.database.sqlite

import org.junit.Assert
import org.junit.Test

/**
 * Test for [MemorySQLiteConn]
 */
class MemorySQLiteConnTest {
    /**
     * Check the jdbc connection is valid.
     */
    @Test
    fun noFileExist() {
        MemorySQLiteConn().value().use {
            Assert.assertTrue(it.isValid(0))
        }
    }
}