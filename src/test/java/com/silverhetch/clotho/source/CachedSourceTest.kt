package com.silverhetch.clotho.source

import com.silverhetch.clotho.Source
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

        assertEquals(
            "1",
            CachedSource(
                "sampleKey",
                0,
                ceres,
                object : Source<String> {
                    var counter = 0
                    override fun value(): String {
                        counter = +1
                        return counter.toString()
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
        val source = CachedSource(
            "sampleKey01",
            100,
            ceres,
            object : Source<String> {
                var counter = 0
                override fun value(): String {
                    counter += 1
                    return counter.toString()
                }
            }
        )
        source.value() // first time with origin
        assertEquals("1", source.value())
    }

    /**
     * Check the value is fetch from origin if previous one is expired
     */
    @Test
    fun secondTime_expired() {
        val ceres = MemoryCeres()
        val source = CachedSource(
            "sampleKey02",
            0,
            ceres,
            object : Source<String> {
                var counter = 0
                override fun value(): String {
                    counter += 1
                    return counter.toString()
                }
            }
        )
        source.value()
        Thread.sleep(1)

        assertEquals(
            "2",
            source.value()
        )
    }
}