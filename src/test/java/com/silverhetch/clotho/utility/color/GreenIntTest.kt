package com.silverhetch.clotho.utility.color

import org.junit.Assert.*
import org.junit.Test

class GreenIntTest{
    @Test
    fun simple() {
        assertEquals(
            160,
            GreenInt(0xFFA0FF).value()
        )
    }
}