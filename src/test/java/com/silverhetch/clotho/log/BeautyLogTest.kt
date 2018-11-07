package com.silverhetch.clotho.log

import org.junit.Test

class BeautyLogTest {
    @Test
    fun simple() {
        BeautyLog().fetch().apply {
            info("Info")
            warning("Warning")
            error("Error")
            debug("Debug")
        }
    }
}
