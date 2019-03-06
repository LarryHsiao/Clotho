package com.silverhetch.clotho.connection.broadcast

import com.silverhetch.clotho.Source
import com.silverhetch.clotho.source.ConstSource
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test
import java.lang.RuntimeException
import java.net.*
import java.util.Enumeration
import java.net.DatagramSocket
import java.net.InetSocketAddress
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.text.Charsets.UTF_8


class BroadcastConnTest {
    @Test
    fun simple() {
        val countDownLatch = CountDownLatch(1)
        var packet = DatagramPacket(ByteArray(0), 0)
        BroadcastConn(
            DatagramSocket(8888, InetAddress.getByName("localhost")).apply {
                broadcast = true
                soTimeout = 1000
            },
            1024,
            ConstSource(InetAddress.getByName("localhost")),
            8888
        ) { incoming ->
            packet = incoming
            countDownLatch.countDown()
        }.apply {
            launch()
            send("ping")
        }
        countDownLatch.await(5, TimeUnit.SECONDS)
        Assert.assertTrue(String(packet.data, UTF_8).startsWith("ping"))
    }
}