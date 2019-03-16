package com.silverhetch.clotho.database.sqlite

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File

class SQLiteConnTest {
    @Before
    fun setUp() {
        File("name").delete()
    }

    @After
    fun tearDown() {
        File("name").delete()
    }

    @Test
    fun connCheck() {
        SQLiteConn("name").value().close()
        assertTrue(File("name").exists())
    }
}