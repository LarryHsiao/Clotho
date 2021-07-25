package com.larryhsiao.clotho.file;

import com.larryhsiao.clotho.Action;
import com.larryhsiao.clotho.io.ProgressedCopy;

import java.io.*;
import java.util.function.Function;

/**
 * Copy given stream ot file.
 */
public class ToFile implements Action {
    private final int bufferSize;
    private final InputStream input;
    private final File dst;
    private final Function<Integer, Void> progress;

    public ToFile(
        InputStream input,
        File dst,
        Function<Integer, Void> progress,
        int bufferSize
    ) {
        this.bufferSize = bufferSize;
        this.input = input;
        this.dst = dst;
        this.progress = progress;
    }

    public ToFile(
        InputStream input,
        File dst,
        Function<Integer, Void> progress
    ) {
        this(input, dst, progress, 1024 * 1024 * 4);
    }

    public ToFile(
        File source,
        File dst,
        Function<Integer, Void> progress
    ) throws FileNotFoundException {
        this(new FileInputStream(source), dst, progress);
    }

    @Override
    public void fire() {
        try {
            new ProgressedCopy(
                input,
                new FileOutputStream(dst),
                bufferSize,
                progress
            ).fire();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
