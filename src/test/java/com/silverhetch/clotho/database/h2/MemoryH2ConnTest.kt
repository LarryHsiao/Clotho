package com.silverhetch.clotho.database.h2

import org.junit.Assert
import org.junit.Test

/**
 * Test for [MemoryH2Conn]
 */
class MemoryH2ConnTest {
    /**
     * Check the jdbc connection is valid.
     */
    @Test
    fun noFileExist() {
        MemoryH2Conn().value().use {
            Assert.assertTrue(it.isValid(0))
        }
    }

    /**
     * Check the exception throws
     */
    @Test
    fun exception() {
        try {
            MemoryH2Conn(";;::").value().use {
                Assert.assertTrue(it.isValid(0))
            }
            Assert.fail()
        } catch (e: IllegalArgumentException) {
            Assert.assertTrue(true)
        }
    }
}