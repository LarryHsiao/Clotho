package com.silverhetch.clotho.log

import org.junit.Assert.*
import org.junit.Test

class HtmlColoredLogTest {

    @Test
    fun simple() {
        with(HtmlColoredLog(object : Log {
            override fun warning(message: String?) {
                assertNotEquals("ABC", message)
            }

            override fun info(message: String?) {
                assertNotEquals("ABC", message)
            }

            override fun error(message: String?) {
                assertNotEquals("ABC", message)
            }

            override fun debug(message: String?) {
                assertNotEquals("ABC", message)
            }
        })) {
            info("ABC")
            error("ABC")
            warning("ABC")
            debug("ABC")
            assertTrue(true)
        }
    }
}