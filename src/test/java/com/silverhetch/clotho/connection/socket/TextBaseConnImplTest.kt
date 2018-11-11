package com.silverhetch.clotho.connection.socket

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream
import org.junit.Assert
import org.junit.Test

/**
 * Test
 */
class TextBaseConnImplTest {

    /**
     * In memory Input/output. Check the content.
     */
    @Test
    fun content() {
        val inputString = "This is input"
        val outputStream = ByteOutputStream(inputString.toByteArray().size)
        TextBaseConnImpl(
            "This is input".byteInputStream().bufferedReader(),
            outputStream.bufferedWriter()) { input ->
            input
        }.apply {
            launch()
            Thread.sleep(3000)
            close()
        }

        Assert.assertEquals(
            inputString,
            outputStream.toString()
        )
    }
}