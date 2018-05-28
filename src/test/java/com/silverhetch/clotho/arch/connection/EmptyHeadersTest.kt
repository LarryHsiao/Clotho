package com.silverhetch.elizabeth.connection

import org.junit.Assert.*
import org.junit.Test

class EmptyHeadersTest{
    @Test
    fun simple() {
        assertTrue(EmptyHeaders().values().isEmpty())
    }
}