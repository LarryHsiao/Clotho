package com.silverhetch.clotho.file

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalArgumentException
import java.nio.file.Files

/**
 * Test for com.silverhetch.clotho.file.SubFiles
 */
class SubFilesTest{
    /**
     * Check the result
     */
    @Test
    fun simple() {
        val root = Files.createTempDirectory("abc")
        val child = Files.createTempFile(root.toAbsolutePath(), "abc","abcd")
        assertEquals(
            child.toFile(),
            SubFiles(root.toFile()).value()[0]
        )
    }

    /**
     * Throw exception if root is not a Directory.
     */
    @Test
    fun notDirException() {
        try{
            SubFiles(Files.createTempFile(
                "1",
                ""
            ).toFile()).value()
            fail()
        }catch (e:IllegalArgumentException){
            assertTrue(true)
        }
    }
}