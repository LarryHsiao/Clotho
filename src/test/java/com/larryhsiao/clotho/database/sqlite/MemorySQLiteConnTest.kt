package com.larryhsiao.clotho.database.sqlite

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
            Assertions.assertTrue(it.isValid(0))
        }
    }
}