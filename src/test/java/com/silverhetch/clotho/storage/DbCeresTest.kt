package com.silverhetch.clotho.storage

import com.silverhetch.clotho.database.SingleConn
import com.silverhetch.clotho.database.sqlite.InMemoryConn
import org.junit.Assert
import org.junit.Test

class DbCeresTest {
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