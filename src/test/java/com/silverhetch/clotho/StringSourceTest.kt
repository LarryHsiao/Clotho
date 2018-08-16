package com.silverhetch.clotho

import org.junit.Assert.*
import org.junit.Test

class StringSourceTest {
    @Test
    fun simple() {
        with("Actual") {
            assertEquals(
                "Actual",
                StringSource(this).fetch()
            )
        }

    }
}