package com.silverhetch.clotho.utility.gateway

import com.silverhetch.clotho.database.SingleConn
import com.silverhetch.clotho.database.sqlite.MemorySQLiteConn
import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.clotho.storage.DbCeres
import org.junit.Assert.*
import org.junit.Test

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