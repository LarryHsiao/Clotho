package com.silverhetch.clotho.file

import org.junit.Assert.*
import org.junit.Test
import java.nio.file.Files

/**
 * Test for [com.silverhetch.clotho.file.FileDelete]
 */
class FileDeleteTest {
    /**
     * Check directory, subdirectory and files is removed successfully.
     */
    @Test
    fun simple() {
        val file = Files.createTempDirectory("prefix").also { root ->
            Files.createTempFile(root, "prefix", "")
            Files.createTempDirectory(root, "prefix").also { subdir ->
                Files.createTempFile(subdir, "prefix", "")
            }
        }.toFile()
        FileDelete(file).fire()
        assertFalse(file.exists())
    }
}