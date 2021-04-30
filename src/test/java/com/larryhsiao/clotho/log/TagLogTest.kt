package com.larryhsiao.clotho.log

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

class TagLogTest {
    @Test
    fun warn() {
        TagLog(object : Log {
            override fun warning(p0: String?) {
                assertEquals("[WARN]: ", p0)
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

    @Test
    fun info() {
        TagLog(object : Log {
            override fun warning(p0: String?) {
                fail<Unit>()
            }

            override fun info(p0: String?) {
                assertEquals("[INFO]: ", p0)
            }

            override fun error(p0: String?) {
                fail<Unit>()
            }

            override fun debug(p0: String?) {
                fail<Unit>()
            }
        }).info("")
    }

    @Test
    fun error() {
        TagLog(object : Log {
            override fun warning(p0: String?) {
                fail<Unit>()
            }

            override fun info(p0: String?) {
                fail<Unit>()
            }

            override fun error(p0: String?) {
                assertEquals("[ERROR]: ", p0)
            }

            override fun debug(p0: String?) {
                fail<Unit>()
            }
        }).error("")
    }

    @Test
    fun debug() {
        TagLog(object : Log {
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
                assertEquals("[DEBUG]: ", p0)
            }
        }).debug("")
    }
}