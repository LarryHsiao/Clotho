package com.larryhsiao.clotho.source

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
                ConstSource("VALUE")
            ).value()
        )
    }
}