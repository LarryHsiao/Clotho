package com.silverhetch.elizabeth.connection

/**
 * Empty header implementation.
 */
class EmptyHeaders : Headers {
    override fun values(): Map<String, String> {
        return HashMap()
    }
}