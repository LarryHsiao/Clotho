package com.larryhsiao.clotho.database.sqlite

import com.larryhsiao.clotho.database.SingleConn
import org.junit.Assert.assertEquals
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