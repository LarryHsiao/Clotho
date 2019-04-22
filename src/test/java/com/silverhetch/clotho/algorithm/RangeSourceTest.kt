package com.silverhetch.clotho.algorithm

import com.silverhetch.clotho.source.ConstSource
import org.junit.Assert.*
import org.junit.Test

class RangeSourceTest {
    @Test
    fun simple() {
        RangeSource(
            ConstSource(arrayListOf(
                5,
                1L,
                2,
                65,
                99
            )
            )
        ).value().let { result ->
            assertEquals(99, result.first)
            assertEquals(1, result.second)
        }
    }

    @Test
    fun simple_negative() {
        RangeSource(
            ConstSource(arrayListOf(
                -5,
                1L,
                2,
                65,
                -99
            )
            )
        ).value().let { result ->
            assertEquals(65, result.first)
            assertEquals(-99, result.second)
        }
    }
}