package com.larryhsiao.clotho.connection.broadcast

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.net.InetAddress

class PhantomTargetTest {
    @Test
    fun simple() {
        val result = PhantomTarget()
        result.name()
        assertEquals(
            InetAddress.getByName("127.0.0.1"),
            result.interfaceInetAddress()
        )
        assertEquals(
            InetAddress.getByName("127.0.0.1"),
            result.broadcastAddress()
        )
    }
}