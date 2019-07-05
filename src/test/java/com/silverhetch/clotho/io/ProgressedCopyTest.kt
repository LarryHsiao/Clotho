package com.silverhetch.clotho.io

import com.silverhetch.clotho.encryption.MD5
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream
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
        val random = Random(System.currentTimeMillis())
        val expectedLength = 8096 * 100
        var copiedLength = 0
        ProgressedCopy(
            ByteArrayInputStream(
                Array(expectedLength) {
                   random.nextBytes(1)[0]
                }.toByteArray()
            ),
            object : OutputStream() {
                override fun write(b: Int) {
                    // leave it empty
                }
            }
        ) { copiedLength = it }.value()

        assertEquals(
            expectedLength,
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


    /**
     * Check copied result with md5
     */
    @Test
    fun checkCopiedResultMD5() {
        val random = Random(System.currentTimeMillis())
        val input = ByteArray(8096 * 100) {
            random.nextBytes(1)[0]
        }
        val output = ByteArrayOutputStream(input.size)
        ProgressedCopy(
            ByteArrayInputStream(input),
            output
        ) {}.value()

        assertEquals(
            MD5(ByteArrayInputStream(input)).value(),
            MD5(ByteArrayInputStream(output.toByteArray())).value()
        )
    }
}