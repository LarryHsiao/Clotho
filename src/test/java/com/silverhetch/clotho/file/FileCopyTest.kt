package com.silverhetch.clotho.file

import com.silverhetch.clotho.encryption.MD5
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test
import java.io.File
import java.nio.charset.Charset
import kotlin.random.Random

/**
 * Tests for [com.silverhetch.clotho.file.FileCopy].
 */
class FileCopyTest {

    /**
     * Check the copied file content.
     */
    @Test
    fun checkContent() {
        val sourceText = "This is source file"
        val src = File.createTempFile("temp", "")
        val dst = File.createTempFile("dest", "")
        TextFile(src, sourceText).value()
        FileCopy(src, dst) {}.value()
        assertEquals(
            sourceText,
            FileText(dst).value()
        )
    }


    /**
     * Check the copied Large file content.
     */
    @Ignore
    @Test
    fun checkContentLarge() {
        val sourceText = CharArray(8096) {
            'c'
        }.contentToString()
        val src = File.createTempFile("temp", "")
        val dst = File.createTempFile("dest", "")
        TextFile(src, sourceText).value()
        FileCopy(src, dst) {}.value()
        assertEquals(
            sourceText,
            FileText(dst).value()
        )
    }
}