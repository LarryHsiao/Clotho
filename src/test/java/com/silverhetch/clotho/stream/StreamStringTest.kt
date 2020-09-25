package com.silverhetch.clotho.stream

import org.junit.Assert
import org.junit.Test
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
        Assert.assertEquals(
            "Test",
            StreamString(
                ByteArrayInputStream("Test".toByteArray())
            ).value()
        )
    }
}