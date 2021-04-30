package com.larryhsiao.clotho.regex

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

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