package com.larryhsiao.clotho

import com.larryhsiao.clotho.utility.StringSource
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Tests for [com.larryhsiao.clotho.SourceWrapper]
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