package com.silverhetch.clotho.log

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class TagLogTest {
    @Test
    fun warn() {
        TagLog(object : Log {
            override fun warning(p0: String?) {
                assertEquals("[WARN]: ", p0)
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
    fun info() {
        TagLog(object : Log {
            override fun warning(p0: String?) {
                fail()
            }

            override fun info(p0: String?) {
                assertEquals("[INFO]: ", p0)
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
    fun error() {
        TagLog(object : Log {
            override fun warning(p0: String?) {
                fail()
            }

            override fun info(p0: String?) {
                fail()
            }

            override fun error(p0: String?) {
                assertEquals("[ERROR]: ", p0)
            }

            override fun debug(p0: String?) {
                fail()
            }
        }).error("")
    }

    @Test
    fun debug() {
        TagLog(object : Log {
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
                assertEquals("[DEBUG]: ", p0)
            }
        }).debug("")
    }
}