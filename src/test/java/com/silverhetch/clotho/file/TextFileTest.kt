package com.silverhetch.clotho.file

import org.junit.Assert.*
import org.junit.Test
import java.nio.file.Files

/**
 * Tests for [com.silverhetch.clotho.file.TextFile].
 */
class TextFileTest {
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