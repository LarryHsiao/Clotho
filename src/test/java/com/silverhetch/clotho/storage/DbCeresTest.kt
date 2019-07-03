package com.silverhetch.clotho.storage

import com.silverhetch.clotho.database.SingleConn
import com.silverhetch.clotho.database.sqlite.InMemoryConn
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
        DbCeres(SingleConn(InMemoryConn())).also {
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