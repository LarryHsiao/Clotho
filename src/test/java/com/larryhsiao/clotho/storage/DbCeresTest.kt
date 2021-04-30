package com.larryhsiao.clotho.storage

import com.larryhsiao.clotho.database.SingleConn
import com.larryhsiao.clotho.database.sqlite.MemorySQLiteConn
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Test for [DbCeres]
 */
class DbCeresTest {
    /**
     * Check the key/value is the same after read/write
     */
    @Test
    fun simple() {
        DbCeres(SingleConn(MemorySQLiteConn())).also {
            it.store("Key1", "value")
            Assertions.assertEquals(
                "value",
                it.get("Key1")
            )

            Assertions.assertEquals(
                "value",
                it.all()["Key1"]
            )
        }
    }
}