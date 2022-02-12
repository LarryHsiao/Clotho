package com.larryhsiao.clotho;

/**
 * Builder class with Type <T>.
 */
public interface Source<T> {
    /**
     * Fetch the data
     */
    T value() throws Exception;
}
