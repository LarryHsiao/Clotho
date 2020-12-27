package com.larryhsiao.clotho.serialization;

import com.google.gson.Gson;

/**
 * Gson implementation of {@link Json}.
 */
public class GsonJson implements Json {
    private final Gson gson;

    public GsonJson() {
        this(new Gson());
    }

    public GsonJson(Gson gson) {
        this.gson = gson;
    }

    @Override
    public <T> String serialize(T input, Class<T> targetClass) {
        return gson.toJson(input, targetClass);
    }

    @Override
    public <T> T deserialize(String input, Class<T> targetClass) {
        return gson.fromJson(input, targetClass);
    }
}
