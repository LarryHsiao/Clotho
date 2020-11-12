package com.larryhsiao.clotho.connection.socket

import org.junit.Assert
import org.junit.Test
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket

/**
 * Unit test.
 */
class SocketConnTest {
    @Test
    fun checkInputOutput() {
        val inputString = "This is input."
        var outputString = ""

        Thread {
            val echoServer = ServerSocket(12305, 0, InetAddress.getByName("localhost"))
            val socket = echoServer.accept()
            val received = socket.getInputStream().bufferedReader().readLine()

            socket.getOutputStream().bufferedWriter().apply {
                write(received)
                flush()
            }
            socket.close()
        }.start()

        Thread.sleep(150)

        val socket = Socket()
        socket.connect(InetSocketAddress("localhost", 12305))
        SocketConn(socket) { _, msg -> outputString = msg }.use {
            it.launch()
            Thread.sleep(150)
            it.send(inputString)
            Thread.sleep(150)
            Assert.assertEquals(
                inputString,
                outputString
            )
        }
    }
}