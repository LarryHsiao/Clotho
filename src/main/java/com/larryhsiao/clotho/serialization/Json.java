package com.larryhsiao.clotho.serialization;

/**
 * Json Serialization.
 */
public interface Json {
    /**
     * Serialize.
     *
     * @param input object any thing you like.
     * @return The actual json.
     */
    <T> String serialize(T input, Class<T> targetClass);

    /**
     * Deserialize to object.
     *
     * @param input Json string.
     * @param <T>   The object type.
     * @return The result of deserialization.
     */
    <T> T deserialize(String input, Class<T> targetClass);
}
