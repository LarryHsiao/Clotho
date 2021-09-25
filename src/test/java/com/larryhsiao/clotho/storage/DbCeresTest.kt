package com.larryhsiao.clotho.storage

import com.larryhsiao.clotho.database.SingleConn
import com.larryhsiao.clotho.database.sqlite.MemorySQLiteConn
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.Exception

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

    /**
     * Test if delete work.
     */
    @Test
    fun delete() {
        DbCeres(SingleConn(MemorySQLiteConn())).also {
            it.store("Key1", "value")
            it.delete("Key1")

            Assertions.assertNull(it.all()["Key1"])
        }
    }

    /**
     * Throw exception if delete failure.
     */
    @Test
    fun deleteNonExist() {
        try {
            DbCeres(SingleConn(MemorySQLiteConn())).also {
                it.delete("Key1")
            }
            Assertions.fail()
        } catch (e: Exception) {
            Assertions.assertTrue(true)
        }
    }
}