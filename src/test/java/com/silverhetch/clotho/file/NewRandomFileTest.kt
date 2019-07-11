package com.silverhetch.clotho.file

import org.junit.Assert.*
import org.junit.Test
import java.nio.file.Files

/**
 * Test for com.silverhetch.clotho.file.NewRandomFile
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