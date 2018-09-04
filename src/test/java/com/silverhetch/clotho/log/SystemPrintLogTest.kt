package com.silverhetch.clotho.log

import org.junit.Assert.*
import org.junit.Test

class SystemPrintLogTest {

    @Test
    fun simple() {
        with(SystemPrintLog()) {
            info("ABC")
            error("ABC")
            warning("ABC")
            debug("ABC")
            assertTrue(true)
        }
    }
}