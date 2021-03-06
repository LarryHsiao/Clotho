package com.larryhsiao.clotho.io

import com.larryhsiao.clotho.dgist.MD5
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.*
import kotlin.random.Random

/**
 * Tests for [com.larryhsiao.clotho.io.ProgressedCopy].
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
            },
            1024 * 1024 * 4
        ) {
            copiedLength = it
            null
        }.fire()

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
            output,
            1024 * 1024 * 4
        ) { null }.fire()

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
            output,
            1024 * 1024 * 4
        ) { null }.fire()

        assertEquals(
            MD5(ByteArrayInputStream(input)).value(),
            MD5(ByteArrayInputStream(output.toByteArray())).value()
        )
    }

    /**
     * Check exception when stream not available.
     */
    @Test
    fun emptyStringIfMd5NotAvailable() {
        try {
            MD5(object : InputStream() {
                override fun read(): Int {
                    throw IOException("Not available")
                }
            }).value()
            fail()
        } catch (e: Exception) {
            Assertions.assertEquals("java.io.IOException: Not available", e.message)
        }
    }
}
