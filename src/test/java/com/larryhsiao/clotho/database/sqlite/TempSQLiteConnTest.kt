package com.larryhsiao.clotho.database.sqlite

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Test for [TempSQLiteConn]
 */
class TempSQLiteConnTest {
    /**
     * Check the connection.
     */
    @Test
    fun simple() {
        TempSQLiteConn().value().use {
            assertTrue(it.isValid(0))
        }
    }
}