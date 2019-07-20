package com.silverhetch.clotho.processor

/**
 * Represent a Processor that handles a input object.
 */
interface Processor<T> {
    /**
     * Do the action with input object.
     */
    fun proceed(input: T)
}