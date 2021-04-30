package com.larryhsiao.clotho.file

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Files

/**
 * Test for com.larryhsiao.clotho.FileBytes
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