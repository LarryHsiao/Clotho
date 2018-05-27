package com.silverhetch.elizabeth.arch.connection

/**
 * Empty header implementation.
 */
class EmptyHeaders : Headers {
    override fun values(): Map<String, String> {
        return HashMap()
    }
}