package com.larryhsiao.clotho.stream

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import java.io.ByteArrayInputStream

/**
 * Test for [StreamString].
 */
internal class StreamStringTest {
    /**
     * Check the output is equal as expect.
     */
    @Test
    internal fun normalCase() {
        Assertions.assertEquals(
            "Test",
            StreamString(
                ByteArrayInputStream("Test".toByteArray())
            ).value()
        )
    }
}