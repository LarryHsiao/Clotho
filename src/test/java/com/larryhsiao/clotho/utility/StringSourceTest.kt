package com.larryhsiao.clotho.utility

import com.larryhsiao.clotho.source.ConstSource
import org.junit.Assert.assertEquals
import org.junit.Test

class StringSourceTest {
    @Test
    fun simple() {
        with("Actual") {
            assertEquals(
                "Actual",
                ConstSource(this).value()
            )
        }
    }
}