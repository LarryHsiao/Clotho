package com.silverhetch.elizabeth.arch

/**
 * Factory interface for General factory classes.
 */
interface Factory<out target> {

    /**
     * Instance of the target
     */
    fun instance(): target
}