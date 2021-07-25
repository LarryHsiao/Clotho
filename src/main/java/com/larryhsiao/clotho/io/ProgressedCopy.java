package com.larryhsiao.clotho.io;

import com.larryhsiao.clotho.Action;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Function;

/**
 * Action to copy data from input to output.
 */
public class ProgressedCopy implements Action {
    private final InputStream input;
    private final OutputStream output;
    private final int bufferSize;
    private final Function<Integer, Void> progress;

    public ProgressedCopy(
        InputStream input,
        OutputStream output,
        int bufferSize,
        Function<Integer, Void> progress
    ) {
        this.input = input;
        this.output = output;
        this.bufferSize = bufferSize;
        this.progress = progress;
    }

    @Override
    public void fire() {
        try {
            read();
            input.close();
            output.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void read() throws Exception {
        final byte[] buffer = new byte[bufferSize];
        if (input.available() == 0) {
            return;
        }
        int read = input.read(buffer);
        int totalLength = 0;
        while (read != -1) {
            output.write(buffer, 0, read);
            totalLength += read;
            progress.apply(totalLength);
            if (input.available() != 0) {
                read = input.read(buffer);
            } else {
                break;
            }
        }
    }
}
