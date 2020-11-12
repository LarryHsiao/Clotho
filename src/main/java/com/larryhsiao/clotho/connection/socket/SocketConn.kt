package com.larryhsiao.clotho.connection.socket

import java.net.Socket

/**
 * Socket stream exchange text base data.
 */
class SocketConn(private val socket: Socket, private val onMessage: (TextBaseConn, String) -> Unit) : TextBaseConn {
    private lateinit var textBaseConn: TextBaseConn

    override fun close() {
        socket.close()
    }

    override fun launch() {
        textBaseConn = TextBaseConnImpl(
            socket.getInputStream().bufferedReader(),
            socket.getOutputStream().bufferedWriter(),
            onMessage
        ).apply { launch() }
    }

    override fun send(msg: String) {
        textBaseConn.send(msg)
    }
}