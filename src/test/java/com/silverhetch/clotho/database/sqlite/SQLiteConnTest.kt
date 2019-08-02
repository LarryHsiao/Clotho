package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.file.TextFile
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File
import java.lang.RuntimeException

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