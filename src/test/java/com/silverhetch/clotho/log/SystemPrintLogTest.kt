package com.silverhetch.clotho.log

import org.junit.Assert.*
import org.junit.Test

/**
 * Test for [SystemPrintLog]
 */
class SystemPrintLogTest {

    /**
     * Simple check if the log invoked with not exception
     */
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