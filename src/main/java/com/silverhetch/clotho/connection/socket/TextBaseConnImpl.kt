package com.silverhetch.clotho.connection.socket

import java.io.BufferedReader
import java.io.BufferedWriter
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Implementation of [TextBaseConn] with two single thread for sending/receiving text messages.
 * This class only handles stream reading and writing.
 * The connection should be established before initialize this class.
 */
class TextBaseConnImpl(private val input: BufferedReader,
                       private val output: BufferedWriter,
                       private val proceedMessage: (msg: String) -> String) : TextBaseConn {
    private val sendThread: ExecutorService = Executors.newSingleThreadScheduledExecutor()
    private var running = false

    override fun launch() {
        if (running) {
            return
        }
        running = true
        Thread {
            while (running) {
                val readResult: String? = input.readLine()
                if (readResult == null) { // End of stream
                    sendThread.submit { close() }
                    return@Thread
                }
                send(
                    proceedMessage(
                        readResult
                    )
                )
            }
        }.start()
    }

    override fun send(msg: String) {
        sendThread.submit {
            output.write(
                msg
            )
            output.flush()
        }
    }

    override fun close() {
        running = false
        input.close()
        output.close()
        sendThread.shutdown()
    }
}