package com.silverhetch.clotho.io

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.*
import kotlin.random.Random

/**
 * Tests for [com.silverhetch.clotho.io.ProgressedCopy].
 */
class ProgressedCopyTest {

    /**
     * Check progress size
     */
    @Test
    fun checkSize() {
        val expectedLength = 8096 * 100
        var copiedLength = 0L
        ProgressedCopy(
            ByteArrayInputStream(ByteArray(expectedLength) {
                1.toByte()
            }),
            object : OutputStream() {
                override fun write(b: Int) {
                    // leave it empty
                }
            }
        ) { copiedLength = it }.value()

        assertEquals(
            expectedLength.toLong(),
            copiedLength
        )
    }


    /**
     * Check copied result
     */
    @Test
    fun checkCopiedResult() {
        val input = "This is input"
        val output = ByteArrayOutputStream(input.toByteArray().size)
        ProgressedCopy(
            input.byteInputStream(),
            output
        ) {}.value()

        assertEquals(
            input,
            String(output.toByteArray())
        )
    }
}