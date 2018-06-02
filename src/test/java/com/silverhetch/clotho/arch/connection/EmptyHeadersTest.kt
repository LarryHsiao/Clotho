package com.silverhetch.clotho.connection

import org.junit.Assert.assertTrue
import org.junit.Test

class EmptyHeadersTest {
    @Test
    fun simple() {
        assertTrue(EmptyHeaders().values().isEmpty())
    }
}