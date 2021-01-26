package com.larryhsiao.clotho.source;

import com.larryhsiao.clotho.Source;

/**
 * Wrapper object for Source
 */
public class SourceWrapper<T> implements Source<T> {
    private final Source<T> original;

    public SourceWrapper(Source<T> original) {
        this.original = original;
    }

    @Override
    public T value() {
        return original.value();
    }
}
