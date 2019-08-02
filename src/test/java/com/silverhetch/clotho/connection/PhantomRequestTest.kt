package com.silverhetch.clotho.connection

import org.junit.Assert.*
import org.junit.Test

/**
 * Test for [PhantomRequest]
 */
class PhantomRequestTest {

    /**
     * Check the output of PhantomRequest
     */
    @Test
    fun simple() {
        assertEquals(
            200,
            PhantomRequest().request().code
        )
        assertEquals(
            "phantom://phantom.host",
            PhantomRequest().url()
        )
    }
}