package com.larryhsiao.clotho.stream;

import com.larryhsiao.clotho.Source;
import com.larryhsiao.clotho.io.ProgressedCopy;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Source to build string from {@link InputStream}.
 */
public class StreamString implements Source<String> {
    private final InputStream inputStream;

    public StreamString(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String value() {
        try {
            final ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
            new ProgressedCopy(
                inputStream,
                byteArrayOutput,
                1024,
                integer -> null
            ).fire();
            inputStream.close();
            byteArrayOutput.close();
            return byteArrayOutput.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
