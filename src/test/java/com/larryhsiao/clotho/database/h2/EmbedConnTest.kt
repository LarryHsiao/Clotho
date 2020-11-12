package com.larryhsiao.clotho.database.h2

import com.larryhsiao.clotho.source.ConstSource
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import java.io.File

/**
 * Test for [EmbedH2Conn] object.
 */
class EmbedConnTest {
    companion object {
        private const val DB_FILE_NAME = "name.mv.db"
    }

    /**
     * Delete db file before setup
     */
    @Before
    fun setUp() {
        File(DB_FILE_NAME).delete()
    }

    /**
     * Delete db file after the test
     */
    @After
    fun tearDown() {
        File(DB_FILE_NAME).delete()
    }

    /**
     * Check the database exist after create a connection once
     */
    @Test
    fun connCheck() {
        val targetFile = File("name")
        EmbedH2Conn(ConstSource<File>(targetFile)).value().close()
        assertTrue(File(DB_FILE_NAME).exists())
    }

    /**
     * Check error when given file is invalid
     */
    @Test
    fun invalidPath() {
        try {
            EmbedH2Conn(ConstSource<File>(File("/"))).value().close()
            fail()
        } catch (e: IllegalArgumentException) {
            assertTrue(true)
        }
    }
}