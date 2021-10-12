package com.larryhsiao.clotho.dgist;

import com.larryhsiao.clotho.Source;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Calculate MD5 of {@link InputStream}.
 */
public class MD5 implements Source<String> {
    private final InputStream input;

    public MD5(InputStream input) {
        this.input = input;
    }

    @Override
    public String value() {
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] buffer = new byte[1024];
            int read = input.read(buffer);
            while (read > 0) {
                md.update(buffer, 0, read);
                read = input.read(buffer);
            }
            input.close();
            return new HexString(md.digest()).value();
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
