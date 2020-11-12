package com.larryhsiao.clotho.connection.socket

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Implementation of [TextBaseConn] with two single thread for sending/receiving text messages.
 *
 * Message receiving/sending triggers by line separator.
 *
 * This class only handles stream reading and writing.
 * The connection should be established before initialize this class.
 */
class TextBaseConnImpl(
    private val input: BufferedReader,
    private val output: BufferedWriter,
    private val proceedMessage: (conn: TextBaseConn, msg: String) -> Unit
) : TextBaseConn {
    private val sendThread: ExecutorService = Executors.newSingleThreadScheduledExecutor()
    private var running = false

    override fun launch() {
        if (running) {
            return
        }
        running = true
        Thread {
            try {
                while (running) {
                    val readResult: String? = input.readLine()
                    if (readResult == null) { // End of stream
                        sendThread.submit { close() }
                        return@Thread
                    }
                    proceedMessage(
                        this, readResult
                    )
                }
            } catch (e: IOException) {
                close()
            }
        }.start()
    }

    override fun send(msg: String) {
        sendThread.submit {
            try {
                output.write(
                    if (msg.endsWith(System.lineSeparator())) {
                        msg
                    } else {
                        "$msg${System.lineSeparator()}"
                    }
                )
                output.flush()
            } catch (e: IOException) {
                close()
            }
        }
    }

    override fun close() {
        running = false
        input.close()
        output.close()
        sendThread.shutdown()
    }
}