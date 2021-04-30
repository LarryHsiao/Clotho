package com.larryhsiao.clotho.utility.gateway

import com.larryhsiao.clotho.database.SingleConn
import com.larryhsiao.clotho.database.sqlite.MemorySQLiteConn
import com.larryhsiao.clotho.source.ConstSource
import com.larryhsiao.clotho.storage.DbCeres
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Test for [CountedGateway]
 */
class CountedGatewayTest {
    /**
     * Test if the triggered count is under max count should not be able trigger the delegation.
     */
    @Test
    fun underMaxCount_noTrigger() {
        val gateway = CountedGateway(
            ConstSource(DbCeres(SingleConn(MemorySQLiteConn()))),
            5
        ) {
            Assertions.fail()
        }
        gateway.value()
    }

    /**
     * Check that it should trigger the delegation.
     */
    @Test
    fun graterMaxCount_triggered() {
        var triggered = false
        val gateway = CountedGateway(
            ConstSource(DbCeres(SingleConn(MemorySQLiteConn()))),
            1
        ) {
            triggered = true
        }
        gateway.value()
        gateway.value()

        Assertions.assertTrue(triggered)
    }
}