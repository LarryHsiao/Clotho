package com.silverhetch.clotho.log

import org.junit.Assert.*
import org.junit.Test

class PhantomLogTest {
    @Test
    fun simple() {
        with(PhantomLog()) {
            // just check if the method exist
            info("ABC")
            warning("ABC")
            error("ABC")
            debug("ABC")
        }
        assertTrue(true)
    }
}