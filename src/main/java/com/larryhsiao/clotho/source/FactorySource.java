package com.larryhsiao.clotho.source;

import com.larryhsiao.clotho.Source;

import java.util.function.Function;

/**
 * Factory source to build a T every time invokes value.
 */
public class FactorySource <T>implements Source<T> {
    private final Function<Void, T> construct;

    public FactorySource(Function<Void, T> construct) {this.construct = construct;}

    @Override
    public T value() {
        return construct.apply(null);
    }
}
