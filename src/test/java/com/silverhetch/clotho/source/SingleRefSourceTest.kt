package com.silverhetch.clotho.source

import com.silverhetch.clotho.Source
import org.junit.Assert
import org.junit.Test

/**
 * Unit-test for the class [SingleRefSource]
 */
class SingleRefSourceTest {

    /**
     * Check reference is the same all the time.
     */
    @Test
    fun reference() {
        var ref: Any? = null
        val source = SingleRefSource(
            object : Source<Any> {
                override fun value(): Any {
                    return SingleRefSourceTest()
                }
            }
        )
        for (i in 0..10) {
            val newRef = source.value()
            if (ref != null && ref != newRef) {
                Assert.fail("Reference changed")
            } else {
                ref = newRef
            }
        }
        Assert.assertTrue(true)
    }
}