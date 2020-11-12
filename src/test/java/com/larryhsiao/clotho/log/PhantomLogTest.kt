package com.larryhsiao.clotho.log

import org.junit.Assert.assertTrue
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