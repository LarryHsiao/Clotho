package com.larryhsiao.clotho.source;

import com.larryhsiao.clotho.Source;

/**
 * Source holding a reference of given T.
 */
public class ConstSource<T> implements Source<T> {
    private final T ref;

    public ConstSource(T ref) {
        this.ref = ref;
    }

    @Override
    public T value() {
        return ref;
    }
}
