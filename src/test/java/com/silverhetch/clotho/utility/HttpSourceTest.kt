package com.silverhetch.clotho.utility

import com.silverhetch.clotho.connection.PhantomRequest
import org.junit.Test

class HttpSourceTest {
    @Test
    fun simple() {
        HttpSource(
            PhantomRequest()
        ).value()
    }
}