package com.larryhsiao.clotho.connection.socket

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

/**
 * Test
 */
class TextBaseConnImplTest {

    /**
     * In memory Input/output. Check the content.
     */
    @Test
    fun content() {
        val inputString = "This is input" + System.lineSeparator()
        val outputStream = ByteArrayOutputStream(inputString.toByteArray().size)
        TextBaseConnImpl(
            inputString.byteInputStream().bufferedReader(),
            outputStream.bufferedWriter()) { conn, input ->
            conn.send(input)
        }.apply {
            launch()
            Thread.sleep(3000)
            close()
        }

        Assertions.assertEquals(
            inputString,
            outputStream.toString()
        )
    }

    /**
     * To check the result is not effected by trigger launch() many times
     */
    @Test
    fun nothingChangeIfTriggerLaunchManyTimes() {
        val inputString = "This is input" + System.lineSeparator()
        val outputStream = ByteArrayOutputStream(inputString.toByteArray().size)
        TextBaseConnImpl(
            inputString.byteInputStream().bufferedReader(),
            outputStream.bufferedWriter()) { conn, input ->
            conn.send(input)
        }.apply {
            launch()
            Thread.sleep(3000)
            close()
        }

        Assertions.assertEquals(
            inputString,
            outputStream.toString()
        )
    }
}