package com.larryhsiao.clotho.database.sqlite

import com.larryhsiao.clotho.database.SingleConn
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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