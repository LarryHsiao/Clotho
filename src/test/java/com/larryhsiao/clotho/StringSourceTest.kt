package com.larryhsiao.clotho

import com.larryhsiao.clotho.utility.StringSource
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