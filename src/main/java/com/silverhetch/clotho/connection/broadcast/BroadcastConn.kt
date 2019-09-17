package com.silverhetch.clotho.connection.broadcast

import com.silverhetch.clotho.Source
import com.silverhetch.clotho.connection.socket.TextBaseConn
import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Simple Broadcast handling class.
 */
class BroadcastConn(
    private val socket: DatagramSocket,
    private val bufferSize: Int = 1024,
    private val broadcastDest: Source<InetAddress>,
    private val port: Int,
    private val onReceive: (packet: DatagramPacket) -> Unit
) : TextBaseConn {
    private val sendThread: ExecutorService = Executors.newSingleThreadScheduledExecutor()
    private var running = false

    override fun launch() {
        if (running) {
            return
        }
        running = true
        val buffer = ByteArray(bufferSize)
        Thread {
            while (running) {
                try {
                    val packet = DatagramPacket(buffer, bufferSize)
                    socket.receive(packet)
                    onReceive(packet)
                } catch (ignore: IOException) {
                    ignore.printStackTrace()
                }
            }
        }.start()
    }

    override fun send(msg: String) {
        sendThread.submit {
            try {
                socket.send(
                    DatagramPacket(
                        msg.toByteArray(),
                        msg.toByteArray().size,
                        broadcastDest.value(),
                        port
                    )
                )
            } catch (ignore: IOException) {
                ignore.printStackTrace()
            }
        }
    }

    override fun close() {
        running = false
        socket.close()
        sendThread.shutdown()
    }
}