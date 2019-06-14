package com.silverhetch.clotho.utility.color

import org.junit.Assert.*
import org.junit.Test

class BlueIntTest{
    @Test
    fun simple() {
        assertEquals(
            160,
            BlueInt(0xFFffA0).value()
        )
    }
}