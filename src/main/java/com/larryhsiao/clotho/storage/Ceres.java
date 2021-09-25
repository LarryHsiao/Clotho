package com.larryhsiao.clotho.storage;

import java.util.Map;

/**
 * Represent a key-value storage in [String].
 */
public interface Ceres {
    /**
     * Store an value with key.
     */
    void store(String key, String value);

    /**
     * Obtain value with given string.
     *
     * @return non-null value returns, not matter the key is exist or not.
     */
    String get(String key);

    /**
     * Retrieve all data in map.
     */
    Map<String, String> all();

    /**
     * Delete given key's entry.
     */
    void delete(String key);
}
