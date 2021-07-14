package com.larryhsiao.clotho.connection.broadcast

import com.larryhsiao.clotho.source.ConstSource
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.text.Charsets.UTF_8

/**
 * Test for [BroadcastConn]
 */
class BroadcastConnTest {
    @Test
    fun simple() {
        val countDownLatch = CountDownLatch(1)
        var packet = DatagramPacket(ByteArray(0), 0)
        val conn = BroadcastConn(
            DatagramSocket(8888, InetAddress.getByName("localhost")).apply {
                broadcast = true
                soTimeout = 1000
            },
            4096,
            ConstSource(InetAddress.getByName("localhost")),
            8888
        ) { incoming ->
            packet = incoming
            countDownLatch.countDown()
        }.apply {
            launch()
            send("ping")
        }
        conn.launch()
        countDownLatch.await(5, TimeUnit.SECONDS)
        conn.close()
        Assertions.assertTrue(String(packet.data, UTF_8).startsWith("ping"))
    }

    /**
     * Send ping with buffer too small.
     * Just receive all the buffer can store.
     */
    @Test
    fun tooSmallBuffer() {
        val countDownLatch = CountDownLatch(1)
        var packet = DatagramPacket(ByteArray(0), 0)
        val conn = BroadcastConn(
            DatagramSocket(8888, InetAddress.getByName("localhost")).apply {
                broadcast = true
                soTimeout = 1000
            },
            1,
            ConstSource(InetAddress.getByName("localhost")),
            8888
        ) { incoming ->
            packet = incoming
            countDownLatch.countDown()
        }.apply {
            launch()
            send("ping")
        }
        conn.launch()
        countDownLatch.await(5, TimeUnit.SECONDS)
        conn.close()
        Assertions.assertEquals(
            "p",
            String(packet.data, UTF_8)
        )
    }
}