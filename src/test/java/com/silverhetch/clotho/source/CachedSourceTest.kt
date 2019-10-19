package com.silverhetch.clotho.source

import com.silverhetch.clotho.Source
import com.silverhetch.clotho.storage.Ceres
import com.silverhetch.clotho.storage.MemoryCeres
import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Test for [com.silverhetch.clotho.source.CachedSource]
 */
class CachedSourceTest {

    /**
     * Check the value of first time
     */
    @Test
    fun firstTime_origin() {
        val ceres = MemoryCeres()
        val key = "sampleKey"

        assertEquals(
            "0",
            CachedSource(
                key,
                0,
                ceres,
                object : Source<String> {
                    var counter = 0
                    override fun value(): String {
                        return counter++.toString()
                    }
                }
            ).value()
        )
    }

    /**
     * Check the value is using cached one if not expired
     */
    @Test
    fun secondTime_notExpired() {
        val ceres = MemoryCeres()
        val key = "sampleKey"
        val source = CachedSource(
            key,
            100,
            ceres,
            object : Source<String> {
                var counter = 0
                override fun value(): String {
                    return counter++.toString()
                }
            }
        )
        source.value() // first time with origin
        assertEquals("0", source.value())
    }

    /**
     * Check the value is fetch from origin if previous one is expired
     */
    @Test
    fun secondTime_expired() {
        val ceres = MemoryCeres()
        val key = "sampleKey"
        val source = CachedSource(
            key,
            0,
            ceres,
            object : Source<String> {
                var counter = 0
                override fun value(): String {
                    return counter++.toString()
                }
            }
        )
        source.value()
        Thread.sleep(1)

        assertEquals(
            "1",
            source.value()
        )
    }
}