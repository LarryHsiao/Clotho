package com.larryhsiao.clotho.file

import com.larryhsiao.clotho.source.ConstSource
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Test for [SizeText]
 */
class SizeTextTest {

    /**
     * Check output
     */
    @Test
    fun simple() {
        assertEquals("1", SizeText(ConstSource(1)).value())
        assertEquals("1 KB", SizeText(ConstSource(1024)).value())
        assertEquals("1.5 KB", SizeText(ConstSource(1536)).value())
        assertEquals("1 MB", SizeText(ConstSource(1048576)).value())
        assertEquals("1 GB", SizeText(ConstSource(1073741824)).value())
        assertEquals("1 TB", SizeText(ConstSource(1099511627776)).value())
    }
}