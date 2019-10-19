package com.silverhetch.clotho.storage

import org.junit.Assert.*
import org.junit.Test

/**
 * Test for [com.silverhetch.clotho.storage.MemoryCeres]
 */
class MemoryCeresTest {

    /**
     * Check the initial memory Ceres output with empty string.
     */
    @Test
    fun empty_nonExistValue() {
        assertEquals(
            "",
            MemoryCeres().get("sampleKey")
        )
    }

    /**
     * Get store data
     */
    @Test
    fun value() {
        val key = "key"
        val value = "value"
        val ceres = MemoryCeres().apply {
            this.store(key, value)
        }
        assertEquals(
            value,
            ceres.get(key)
        )
    }

    /**
     * Check all value
     */
    @Test
    fun allValue() {
        val key = "key"
        val value = "value"
        val ceres = MemoryCeres().apply {
            this.store(key, value)
        }
        assertEquals(1, ceres.all().size)
        assertEquals(value, ceres.all()[key])
    }


    /**
     * Check all value
     */
    @Test
    fun updateValue() {
        val key = "key"
        val value = "value"
        val newValue = "newValue"
        val ceres = MemoryCeres().apply {
            this.store(key, value)
            this.store(key, newValue)
        }
        assertEquals(1, ceres.all().size)
        assertEquals(newValue, ceres.all()[key])
    }
}