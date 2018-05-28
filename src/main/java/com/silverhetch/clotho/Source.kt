package com.silverhetch.clotho

/**
 * Data source with Type <T>.
 */
interface Source<T> {
    /**
     * Fetch the data
     */
    fun fetch(): T
}