package com.larryhsiao.clotho.log;

import com.larryhsiao.clotho.Source;

/**
 * Source to print the result to console before returning it.
 */
public class PrintedSource<T> implements Source<T> {
    private final Source<T> original;

    public PrintedSource(Source<T> original) {
        this.original = original;
    }

    @Override
    public T value() {
        final T result = original.value();
        System.out.println(result.toString());
        return result;
    }
}
