package com.silverhetch.clotho.database.sqlite

import org.junit.Assert
import org.junit.Test

/**
 * Test for [InMemoryConn]
 */
class InMemoryConnTest {
    /**
     * Check the jdbc connection is valid.
     */
    @Test
    fun noFileExist() {
        InMemoryConn().value().use {
            Assert.assertTrue(it.isValid(0))
        }
    }
}