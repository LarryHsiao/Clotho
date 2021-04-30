package com.larryhsiao.clotho.database.h2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
            Assertions.assertTrue(it.isValid(0))
        }
    }

    /**
     * Check the exception throws
     */
    @Test
    fun exception() {
        try {
            MemoryH2Conn(";;::").value().use {
                Assertions.assertTrue(it.isValid(0))
            }
            Assertions.fail()
        } catch (e: IllegalArgumentException) {
            Assertions.assertTrue(true)
        }
    }
}