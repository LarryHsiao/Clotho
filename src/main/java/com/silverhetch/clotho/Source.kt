package com.silverhetch.elizabeth.arch

/**
 * Data source with Type <T>.
 */
interface Source<T> {
    /**
     * Fetch the data
     */
    fun fetch(): T
}