package com.larryhsiao.clotho.database.h2

import com.larryhsiao.clotho.source.ConstSource
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

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
    @BeforeEach
    fun setUp() {
        File(DB_FILE_NAME).delete()
    }

    /**
     * Delete db file after the test
     */
    @AfterEach
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