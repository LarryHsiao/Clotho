package com.larryhsiao.clotho.dgist;

import com.larryhsiao.clotho.Source;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * HmacSHA1 with given data and secret.
 */
public class HmacSHA1 implements Source<byte[]> {
    private final Source<byte[]> data;
    private final String secret;

    public HmacSHA1(Source<byte[]> data, String secret) {
        this.data = data;
        this.secret = secret;
    }

    @Override
    public byte[] value() {
        try {
            final SecretKeySpec signingKey = new SecretKeySpec(
                secret.getBytes(UTF_8),
                "HmacSHA1"
            );
            final Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            return mac.doFinal(data.value());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
