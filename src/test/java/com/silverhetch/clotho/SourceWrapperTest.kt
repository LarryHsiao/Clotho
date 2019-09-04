package com.silverhetch.clotho

import com.silverhetch.clotho.utility.StringSource
import org.junit.Assert.*
import org.junit.Test

/**
 * Tests for [com.silverhetch.clotho.SourceWrapper]
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