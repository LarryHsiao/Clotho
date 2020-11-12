package com.larryhsiao.clotho.storage

import com.larryhsiao.clotho.database.SingleConn
import com.larryhsiao.clotho.database.sqlite.MemorySQLiteConn
import org.junit.Assert
import org.junit.Test

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
            Assert.assertEquals(
                "value",
                it.get("Key1")
            )

            Assert.assertEquals(
                "value",
                it.all()["Key1"]
            )
        }
    }
}