package com.silverhetch.clotho.date.recurring

/**
 * The recurring meta
 */
interface Meta {
    /**
     * Start date
     */
    fun start():Long

    /**
     * Recurring interval
     */
    fun interval():Long

    /**
     * The year to repeat
     */
    fun year():Int

    /**
     * The month to repeat
     */
    fun month():Int

    /**
     * The day to repeat
     */
    fun day():Int

    /**
     * The week to repeat
     */
    fun week():Int

    /**
     * The weakday to repeat
     */
    fun weekday():Int
}