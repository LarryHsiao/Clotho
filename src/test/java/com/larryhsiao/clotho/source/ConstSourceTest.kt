package com.larryhsiao.clotho.source

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstSourceTest {
    @Test
    fun simple() {
        assertEquals(
            "TestString",
            ConstSource("TestString").value()
        )
    }
}