package com.silverhetch.clotho.connection

import org.junit.Assert.*
import org.junit.Test

class PhantomRequestTest {

    @Test
    fun simple() {
        assertEquals(
            200,
            PhantomRequest().request()
        )
    }
}