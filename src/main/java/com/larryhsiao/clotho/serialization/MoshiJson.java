package com.larryhsiao.clotho.serialization;

import com.squareup.moshi.Moshi;

import java.io.IOException;

/**
 * Moshi implementation of {@link Json}.
 */
public class MoshiJson implements Json {
    private final Moshi moshi;

    public MoshiJson() {
        this(new Moshi.Builder().build());
    }

    public MoshiJson(Moshi moshi) {
        this.moshi = moshi;
    }

    @Override
    public <T> String serialize(T input, Class<T> targetClass) {
        return moshi.adapter(targetClass).toJson(input);
    }

    @Override
    public <T> T deserialize(String input, Class<T> targetClass) {
        try {
            return moshi.adapter(targetClass).fromJson(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
