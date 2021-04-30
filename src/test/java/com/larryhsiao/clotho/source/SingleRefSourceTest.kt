package com.larryhsiao.clotho.source

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        val source = SingleRefSource { SingleRefSourceTest() }
        for (i in 0..10) {
            val newRef = source.value()
            if (ref != null && ref != newRef) {
                Assertions.fail("Reference changed")
            } else {
                ref = newRef
            }
        }
        Assertions.assertTrue(true)
    }
}