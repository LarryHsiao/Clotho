package com.silverhetch.elizabeth.coffeepot

/**
 * Cup for the coffee.
 */
interface Cup {
    fun pour(coffee: Coffee)
    fun content(): Coffee
}