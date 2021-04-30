package com.larryhsiao.clotho.file

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Files

/**
 * Test for com.larryhsiao.clotho.NewRandomFile
 */
class NewRandomFileTest {
    /**
     * Check availability.
     */
    @Test
    fun simple() {
        val root = Files.createTempDirectory("1234").toFile()
        NewRandomFile(root).value()
        assertEquals(
            1,
            root.listFiles()?.size ?: 0
        )
    }
}