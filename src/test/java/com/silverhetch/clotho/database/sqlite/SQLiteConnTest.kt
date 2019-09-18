package com.silverhetch.clotho.database.sqlite

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File

/**
 * Test for [SQLiteConn] object.
 */
class SQLiteConnTest {
    @Before
    fun setUp() {
        File("name").delete()
    }

    @After
    fun tearDown() {
        File("name").delete()
    }

    /**
     * Check the database exist after create a connection once
     */
    @Test
    fun connCheck() {
        SQLiteConn("name").value().close()
        assertTrue(File("name").exists())
    }
}