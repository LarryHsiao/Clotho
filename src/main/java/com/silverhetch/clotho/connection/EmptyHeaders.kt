package com.silverhetch.clotho.connection

/**
 * Empty header implementation.
 */
class EmptyHeaders : Headers {
    override fun values(): Map<String, String> {
        return HashMap()
    }
}