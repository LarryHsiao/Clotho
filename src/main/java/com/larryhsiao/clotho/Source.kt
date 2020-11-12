package com.larryhsiao.clotho

/**
 * Builder class with Type <T>.
 */
interface Source<T> {
    /**
     * Fetch the data
     */
    fun value(): T
}