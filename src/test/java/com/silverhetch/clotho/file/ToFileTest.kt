package com.silverhetch.clotho.file

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

/**
 * Tests for [com.silverhetch.clotho.file.ToFile].
 */
class ToFileTest {

    /**
     * Check the copied file content.
     */
    @Test
    fun checkContent() {
        val sourceText = "This is source file"
        val src = File.createTempFile("temp", "")
        val dst = File.createTempFile("dest", "")
        TextFile(src, sourceText).value()
        ToFile(src, dst) {}.fire()
        assertEquals(
            sourceText,
            FileText(dst).value()
        )
    }

    /**
     * Check the copied Large file content.
     */
    @Test
    fun checkContentLarge() {
        val sourceText = CharArray(8096) {
            'c'
        }.contentToString()
        val src = File.createTempFile("temp", "")
        val dst = File.createTempFile("dest", "")
        TextFile(src, sourceText).value()
        ToFile(src, dst) {}.fire()
        assertEquals(
            sourceText,
            FileText(dst).value()
        )
    }
}