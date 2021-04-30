package com.larryhsiao.clotho.utility.gateway

import com.larryhsiao.clotho.database.SingleConn
import com.larryhsiao.clotho.database.sqlite.MemorySQLiteConn
import com.larryhsiao.clotho.source.ConstSource
import com.larryhsiao.clotho.storage.DbCeres
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Test for [TimedCountGateway]
 */
class TimedCountGatewayTest {
    /**
     * Trigger once should not trigger the callback
     */
    @Test
    fun singleTrigger() {
        TimedCountGateway(
            ConstSource(DbCeres(SingleConn(MemorySQLiteConn())))
        ) {
            fail()
        }
        assertTrue(true)
    }

    /**
     * should trigger after exceed max times
     */
    @Test
    fun multiTrigger_grater() {
        var triggered = false
        val gateway = TimedCountGateway(
            ConstSource(DbCeres(SingleConn(MemorySQLiteConn())))
        ) {
            triggered = true
        }
        for (i in 0..10) {
            gateway.value()
        }

        assertTrue(triggered)
    }

    /**
     * Should not trigger when have multi triggered but less then the max
     */
    @Test
    fun multiTrigger_less() {
        var triggered = false
        val gateway = TimedCountGateway(
            ConstSource(DbCeres(SingleConn(MemorySQLiteConn())))
        ) {
            triggered = true
        }
        for (i in 0..9) {
            gateway.value()
        }

        assertFalse(triggered)
    }
}