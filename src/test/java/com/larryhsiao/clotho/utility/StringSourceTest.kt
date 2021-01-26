package com.larryhsiao.clotho.utility

import org.junit.Assert.assertEquals
import org.junit.Test

class StringSourceTest {
    @Test
    fun simple() {
        with("Actual") {
            assertEquals(
                "Actual",
                StringSource(this).value()
            )
        }
    }
}