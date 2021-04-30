package com.larryhsiao.clotho.connection.broadcast

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.net.InetAddress

class PhantomTargetTest {
    @Test
    fun simple() {
        assertEquals(
            InetAddress.getByName("127.0.0.1"),
            PhantomTarget().interfaceInetAddress()
        )
        assertEquals(
            InetAddress.getByName("127.0.0.1"),
            PhantomTarget().broadcastAddress()
        )
    }
}