package com.silverhetch.clotho.database.sqlite

import com.silverhetch.clotho.database.SingleConn
import org.junit.Assert.*
import org.junit.Test

class SingleConnTest {

    @Test
    fun simple() {
        SingleConn(
            MemorySQLiteConn()
        ).let {
            assertEquals(it.value(), it.value())
        }
    }
}