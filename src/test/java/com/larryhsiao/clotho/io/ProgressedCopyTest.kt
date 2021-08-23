package com.larryhsiao.clotho.io

import com.larryhsiao.clotho.dgist.MD5
import com.larryhsiao.clotho.file.FileText
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.*
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
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
            assertEquals("java.io.IOException: Not available", e.message)
        }
    }

    /**
     * No blocking when input stream have no available bytes.
     */
    @Test
    fun notBlockingWhenNoAvailable() {
        val executor = Executors.newCachedThreadPool()
        val future = executor.submit(Callable {
            ProgressedCopy(
                ByteArrayInputStream(ByteArray(0)),
                ByteArrayOutputStream(),
                1024 * 1024 * 4
            ) { null }.fire()
        })
        try {
            future[5, TimeUnit.SECONDS]
            Assertions.assertTrue(true)
        } catch (ex: TimeoutException) {
            fail<Unit>()
        } finally {
            future.cancel(true) // may or may not desire this
        }
    }

    /**
     * Still read stream when no available.
     */
    @Test
    fun blockingWhenNoAvailable() {
        val executor = Executors.newCachedThreadPool()
        val future = executor.submit(Callable {
            ProgressedCopy(
                ByteArrayInputStream(ByteArray(1)),
                ByteArrayOutputStream(),
                1024 * 1024 * 4,
                true
            ) { null }.fire()
        })
        try {
            future[5, TimeUnit.SECONDS]
            Assertions.assertTrue(true)
        } catch (ex: TimeoutException) {
            fail<Unit>()
        } finally {
            future.cancel(true) // may or may not desire this
        }
    }

    /**
     * No blocking when input stream have no available bytes.
     */
    @Test
    fun readAllData() {
        val target = File.createTempFile("prefix", "suffix")
        ProgressedCopy(
            ByteArrayInputStream("ABC".toByteArray()),
            FileOutputStream(target),
            1
        ) { null }.fire()

        Assertions.assertEquals(
            "ABC",
            FileText(target).value()
        )
    }

    /**
     * Should throw exception when outputStream can not write.
     */
    @Test
    fun exceptionCantNotWrite() {
        try {
            ProgressedCopy(
                ByteArrayInputStream("Test".toByteArray()),
                object : OutputStream() {
                    override fun write(p0: Int) {
                        throw RuntimeException("Write failed")
                    }
                },
                1024 * 1024 * 4
            ) { null }.fire()
            fail<Unit>()
        } catch (ignore: Exception) {
            assertTrue(true)
        }
    }
}
