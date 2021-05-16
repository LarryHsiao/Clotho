package com.larryhsiao.clotho.io;

import com.larryhsiao.clotho.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.io.ByteArrayInputStream;
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
        new ProgressedCopy(
            new ByteArrayInputStream(content.getBytes()),
            stream,
            1024 * 1024 * 4,
            integer -> null
        ).fire();
    }
}
