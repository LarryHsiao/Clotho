package com.larryhsiao.clotho.database.sqlite

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

/**
 * Test for [SQLiteConn] object.
 */
class SQLiteConnTest {
    @BeforeEach
    fun setUp() {
        File("name").delete()
    }

    @AfterEach
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