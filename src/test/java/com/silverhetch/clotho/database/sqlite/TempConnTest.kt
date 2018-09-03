package com.silverhetch.clotho.database.sqlite

import org.junit.Assert.*
import org.junit.Test

class TempConnTest {
    @Test
    fun simple() {
        TempConn().fetch().use {
            assertTrue(it.isValid(0))
        }
    }
}