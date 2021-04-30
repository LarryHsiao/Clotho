package com.larryhsiao.clotho.log

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PhantomLogTest {
    @Test
    fun simple() {
        val log = PhantomLog()
        // just check if the method exist
        log.info("ABC")
        log.warning("ABC")
        log.error("ABC")
        log.debug("ABC")
        assertTrue(true)
    }
}