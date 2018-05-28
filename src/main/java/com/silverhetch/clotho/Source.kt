package com.silverhetch.elizabeth

/**
 * Data source with Type <T>.
 */
interface Source<T> {
    /**
     * Fetch the data
     */
    fun fetch(): T
}