package com.silverhetch.elizabeth.arch

/**
 * Factory interface for General factory classes.
 */
interface Factory<out T> {

    /**
     * Instance of the target
     */
    fun instance(): T
}