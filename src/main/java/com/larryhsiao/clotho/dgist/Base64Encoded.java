package com.larryhsiao.clotho.dgist;

import com.larryhsiao.clotho.Source;

import java.util.Base64;

/**
 * Encode given ByteArray to Base64 String.
 */
public class Base64Encoded implements Source<String> {
    private final Source<byte[]> data;

    public Base64Encoded(Source<byte[]> data) {
        this.data = data;
    }

    @Override
    public String value() {
        return Base64.getEncoder().encodeToString(data.value());
    }
}
