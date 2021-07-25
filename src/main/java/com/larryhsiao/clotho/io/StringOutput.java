package com.larryhsiao.clotho.io;

import com.larryhsiao.clotho.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Action to output given String to {@link OutputStream}.
 */
public class StringOutput implements Action {
    private final String content;
    private final OutputStream stream;

    public StringOutput(String content, OutputStream stream) {
        this.content = content;
        this.stream = stream;
    }

    @Override
    public void fire() {
        try (InputStream inputStream = new ByteArrayInputStream(content.getBytes())) {
            new ProgressedCopy(
                inputStream,
                stream,
                1024 * 1024 * 4,
                integer -> null
            ).fire();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
