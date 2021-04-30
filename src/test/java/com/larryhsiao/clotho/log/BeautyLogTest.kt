package com.larryhsiao.clotho.log

import org.junit.jupiter.api.Test

class BeautyLogTest {
    @Test
    fun simple() {
        BeautyLog().value().apply {
            info("Info")
            warning("Warning")
            error("Error")
            debug("Debug")
        }
    }
}
