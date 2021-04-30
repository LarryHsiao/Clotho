package com.larryhsiao.clotho.processor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Test for com.larryhsiao.clotho.Processors
 */
class ProcessorsTest {

    /**
     * Check if all the processor triggered
     */
    @Test
    fun simple() {
        var counter = 0
        Processors(
            object : Processor<Any> {
                override fun proceed(input: Any) {
                    counter++
                }
            },
            object : Processor<Any> {
                override fun proceed(input: Any) {
                    counter++
                }
            }
        ).proceed(Any())

        assertEquals(2, counter)
    }

    /**
     * Check not continue proceed next processor if exception throed
     */
    @Test
    fun exception() {
        var counter = 0
        Processors(
            object : Processor<Any> {
                override fun proceed(input: Any) {
                    counter++
                    throw IllegalStateException()
                }
            },
            object : Processor<Any> {
                override fun proceed(input: Any) {
                    counter++
                }
            }
        ).proceed(Any())
        assertEquals(1, counter)
    }
}