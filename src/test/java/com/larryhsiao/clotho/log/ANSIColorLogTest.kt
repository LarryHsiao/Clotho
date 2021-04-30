package com.larryhsiao.clotho.log

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

/**
 * Test for ANSIColorLog
 */
class ANSIColorLogTest {
    /**
     * Test info output
     */
    @Test
    fun info() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                fail<Unit>()
            }

            override fun info(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_CYAN + ANSIColorLog.ANSI_RESET, p0)
            }

            override fun error(p0: String?) {
                fail<Unit>()
            }

            override fun debug(p0: String?) {
                fail<Unit>()
            }
        }).info("")
    }

    /**
     * Test warning output
     */
    @Test
    fun warning() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_YELLOW + ANSIColorLog.ANSI_RESET, p0)
            }

            override fun info(p0: String?) {
                fail<Unit>()
            }

            override fun error(p0: String?) {
                fail<Unit>()
            }

            override fun debug(p0: String?) {
                fail<Unit>()
            }
        }).warning("")
    }

    /**
     * Test error output
     */
    @Test
    fun error() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                fail<Unit>()
            }

            override fun info(p0: String?) {
                fail<Unit>()
            }

            override fun error(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_RED + ANSIColorLog.ANSI_RESET, p0)
            }

            override fun debug(p0: String?) {
                fail<Unit>()
            }
        }).error("")
    }

    /**
     * Test debug output
     */
    @Test
    fun debug() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                fail<Unit>()
            }

            override fun info(p0: String?) {
                fail<Unit>()
            }

            override fun error(p0: String?) {
                fail<Unit>()
            }

            override fun debug(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_BLUE + ANSIColorLog.ANSI_RESET, p0)
            }
        }).debug("")
    }
}