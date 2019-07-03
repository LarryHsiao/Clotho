package com.silverhetch.clotho.utility.gateway

import com.silverhetch.clotho.database.SingleConn
import com.silverhetch.clotho.database.sqlite.InMemoryConn
import com.silverhetch.clotho.source.ConstSource
import com.silverhetch.clotho.storage.DbCeres
import org.junit.Assert
import org.junit.Test

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
            ConstSource(DbCeres(SingleConn(InMemoryConn()))),
            5
        ) {
            Assert.fail()
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
            ConstSource(DbCeres(SingleConn(InMemoryConn()))),
            1
        ) {
            triggered = true
        }
        gateway.value()
        gateway.value()

        Assert.assertTrue(triggered)
    }
}