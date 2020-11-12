package com.larryhsiao.clotho.database.sqlite

import org.junit.Assert.assertTrue
import org.junit.Test

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