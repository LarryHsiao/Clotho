package com.larryhsiao.clotho

import com.larryhsiao.clotho.source.ConstSource

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringSourceTest {
    @Test
    fun simple() {
            assertEquals(
                "Actual",
                ConstSource("Actual").value()
            )
    }
}