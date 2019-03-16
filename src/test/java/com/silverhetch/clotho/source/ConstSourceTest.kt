package com.silverhetch.clotho.source

import org.junit.Assert.assertEquals
import org.junit.Test

class ConstSourceTest {
    @Test
    fun simple() {
        assertEquals(
            "TestString",
            ConstSource("TestString").value()
        )
    }
}