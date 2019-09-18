package com.silverhetch.clotho.processor

import org.junit.Assert.assertEquals
import org.junit.Test
import org.omg.CORBA.portable.UnknownException

/**
 * Test for com.silverhetch.clotho.processor.Processors
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
                    throw UnknownException(Exception())
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