package com.silverhetch.clotho.file

import org.junit.Assert.*
import org.junit.Test
import java.nio.file.Files

/**
 * Test for com.silverhetch.clotho.file.FileBytes
 */
class FileBytesTest {

    @Test
    fun simple() {
        val targetFile = Files.createTempFile(
            "test",
            ""
        ).toFile()
        val data = "This is ample data"
        TextFile(
            targetFile,
            data
        ).value()

        assertEquals(
            data.toByteArray().size,
            FileBytes(
                targetFile
            ).value().size
        )
    }
}