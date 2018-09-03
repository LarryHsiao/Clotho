package com.silverhetch.clotho

import com.silverhetch.clotho.utility.StringSource
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