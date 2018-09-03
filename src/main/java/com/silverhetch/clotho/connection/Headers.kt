package com.silverhetch.clotho.connection

/**
 * Represent the web request headers
 */
interface Headers {
    /**
     * @return map of headers.
     */
    fun values(): Map<String, String>
}