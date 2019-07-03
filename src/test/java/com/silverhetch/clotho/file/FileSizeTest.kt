package com.silverhetch.clotho.file

import org.junit.Assert.*
import org.junit.Test
import java.nio.file.Files

/**
 * Tests for [com.silverhetch.clotho.file.FileSize].
 */
class FileSizeTest {
    @Test
    fun textFileSize() {
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
            content.length.toLong(),
            FileSize(
                tempFile
            ).value()
        )
    }
}