package com.larryhsiao.clotho.file

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Files

/**
 * Tests for [com.larryhsiao.clotho.file.TextFile].
 */
class TextFileTest {
    /**
     * Check the read/write result is same as input.
     */
    @Test
    fun simple() {
        val tempFile = Files.createTempFile("Prefix", "")
        val content = """
            |This is hello world
            |This is second line
        """.trimMargin()
        TextFile(
            tempFile.toFile(),
            content
        ).value()

        assertEquals(
            content,
            FileText(
                tempFile.toFile()
            ).value()
        )
    }
}