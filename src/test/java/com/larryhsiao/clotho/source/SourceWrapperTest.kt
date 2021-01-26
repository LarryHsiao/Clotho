package com.larryhsiao.clotho.source

import com.larryhsiao.clotho.source.SourceWrapper
import com.larryhsiao.clotho.utility.StringSource
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Tests for [com.larryhsiao.clotho.source.SourceWrapper]
 */
class SourceWrapperTest {
    /**
     * Check the value trigger in wrapper
     */
    @Test
    fun simple() {
        assertEquals(
            "VALUE",
            SourceWrapper(
                StringSource("VALUE")
            ).value()
        )
    }
}