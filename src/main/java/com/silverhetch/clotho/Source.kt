package com.silverhetch.clotho

/**
 * Data source with Type <T>.
 * @todo #refactor-1 remove this class which is redundant
 */
interface Source<T> {
    /**
     * Fetch the data
     */
    fun fetch(): T
}