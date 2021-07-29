package com.larryhsiao.clotho.stream;

import com.larryhsiao.clotho.Action;

import java.io.Closeable;

/**
 * Action to clos a closable object without throwing anything which we can't handle anyway.
 */
public class StreamClosing implements Action {
    private final Closeable closeable;

    public StreamClosing(Closeable closeable) {
        this.closeable = closeable;
    }

    @Override
    public void fire() {
        try {
            closeable.close();
        } catch (Exception ignore) {
        }
    }
}
