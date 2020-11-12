package com.larryhsiao.clotho.connection.socket

import java.io.Closeable

/**
 * Connection which transfer string messages.
 */
interface TextBaseConn : Closeable {
    /**
     * Launch this connection, which can initial resource for handling.
     */
    fun launch()

    /**
     * Send message in string.
     */
    fun send(msg: String)
}