package com.silverhetch.clotho.regex

import org.junit.Assert.*
import org.junit.Test

class IsMailTest {
    @Test
    fun positive() {
        assertTrue(
            IsMail(
                "larryhsiao@larryhsiao.com"
            ).value()
        )
    }


    @Test
    fun negative_missing_com() {
        assertFalse(
            IsMail(
                "larryhsiao@larryhsiao"
            ).value()
        )
    }


    @Test
    fun negative_missing_at() {
        assertFalse(
            IsMail(
                "larryhsiaolarryhsiao.com"
            ).value()
        )
    }
}