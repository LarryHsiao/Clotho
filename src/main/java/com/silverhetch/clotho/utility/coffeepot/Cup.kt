package com.silverhetch.elizabeth.coffeepot

/**
 * Cup for the coffee.
 */
interface Cup {
    /**
     * Pour the coffee into cup
     */
    fun pour(coffee: Coffee)

    /**
     * @return the Coffee object in this cup
     */
    fun content(): Coffee
}