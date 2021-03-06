package com.larryhsiao.clotho.file

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Files

/**
 * Tests for [com.larryhsiao.clotho.file.FileSize].
 */
class FileSizeTest {
    /**
     * Check file size is same as input.
     */
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