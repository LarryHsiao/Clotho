package com.silverhetch.clotho.log

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class ANSIColorLogTest {
    @Test
    fun info() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                fail()
            }

            override fun info(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_CYAN + ANSIColorLog.ANSI_RESET, p0)
            }

            override fun error(p0: String?) {
                fail()
            }

            override fun debug(p0: String?) {
                fail()
            }
        }).info("")
    }

    @Test
    fun warning() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_YELLOW + ANSIColorLog.ANSI_RESET, p0)
            }

            override fun info(p0: String?) {
                fail()
            }

            override fun error(p0: String?) {
                fail()
            }

            override fun debug(p0: String?) {
                fail()
            }
        }).warning("")
    }

    @Test
    fun error() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                fail()
            }

            override fun info(p0: String?) {
                fail()
            }

            override fun error(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_RED + ANSIColorLog.ANSI_RESET, p0)
            }

            override fun debug(p0: String?) {
                fail()
            }
        }).error("")
    }

    @Test
    fun debug() {
        ANSIColorLog(object : Log {
            override fun warning(p0: String?) {
                fail()
            }

            override fun info(p0: String?) {
                fail()
            }

            override fun error(p0: String?) {
                fail()
            }

            override fun debug(p0: String?) {
                assertEquals(ANSIColorLog.ANSI_BLUE + ANSIColorLog.ANSI_RESET, p0)
            }
        }).debug("")
    }
}