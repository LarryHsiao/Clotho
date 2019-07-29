package com.silverhetch.clotho.file

import org.junit.Assert.*
import org.junit.Test
import java.io.IOException
import java.nio.file.Files

/**
 * Test for [com.silverhetch.clotho.file.FileDelete]
 */
class FileDeleteTest {
    companion object {
        private const val PREFIX = "prefix"
    }

    /**
     * Check directory, subdirectory and files is removed successfully.
     */
    @Test
    fun complexStructure() {
        val file = Files.createTempDirectory(PREFIX).also { root ->
            Files.createTempFile(root, PREFIX, "")
            Files.createTempDirectory(root, PREFIX).also { subdir ->
                Files.createTempFile(subdir, PREFIX, "")
            }
        }.toFile()
        FileDelete(file).fire()
        assertFalse(file.exists())
    }

    /**
     * Remove single file
     */
    @Test
    fun fileOnly() {
        val file = Files.createTempFile(PREFIX, "").toFile()
        FileDelete(file).fire()
        assertFalse(file.exists())
    }
}