package com.larryhsiao.clotho.storage

/**
 * Represent a key-value storage in [String].
 */
interface Ceres {
    /**
     * Store an value with key.
     */
    fun store(key: String, value: String)

    /**
     * Obtain value with given string.
     *
     * @return non-null value returns, not matter the key is exist or not.
     */
    fun get(key: String): String

    /**
     * Retrieve all data in map.
     */
    fun all(): Map<String, String>
}