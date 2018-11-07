package com.silverhetch.clotho.utility.gateway

import com.silverhetch.clotho.database.SingleConn
import com.silverhetch.clotho.database.sqlite.InMemoryConn
import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.clotho.storage.DbCeres
import org.junit.Assert.*
import org.junit.Test

class TimedCountGatewayTest {
    @Test
    fun singleTrigger() {
        TimedCountGateway(
            ConstSource(DbCeres(SingleConn(InMemoryConn())))
        ) {
            fail()
        }
        assertTrue(true)
    }


    @Test
    fun multiTrigger_grater() {
        var triggered = false
        val gateway = TimedCountGateway(
            ConstSource(DbCeres(SingleConn(InMemoryConn())))
        ) {
            triggered = true
        }
        for (i in 0..10) {
            gateway.fetch()
        }

        assertTrue(triggered)
    }


    @Test
    fun multiTrigger_less() {
        var triggered = false
        val gateway = TimedCountGateway(
            ConstSource(DbCeres(SingleConn(InMemoryConn())))
        ) {
            triggered = true
        }
        for (i in 0..9) {
            gateway.fetch()
        }

        assertFalse(triggered)
    }
}