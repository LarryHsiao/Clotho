package com.silverhetch.elizabeth.arch.connection

import org.junit.Assert.*
import org.junit.Test

class EmptyHeadersTest{
    @Test
    fun simple() {
        assertTrue(EmptyHeaders().values().isEmpty())
    }
}