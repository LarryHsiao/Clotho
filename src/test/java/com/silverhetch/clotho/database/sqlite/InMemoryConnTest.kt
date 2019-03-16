package com.silverhetch.clotho.database.sqlite

import org.junit.Assert
import org.junit.Test

class InMemoryConnTest {
    @Test
    fun noFileExist() {
        InMemoryConn().value().use {
            Assert.assertTrue(it.isValid(0))
        }
    }
}