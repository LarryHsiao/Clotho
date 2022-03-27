package com.larryhsiao.clotho;

/**
 * Constant source
 */
public class ConstSource<T> implements Source<T> {

    private final T constant;

    public ConstSource(T constant) {this.constant = constant;}

    @Override
    public T value() throws Exception {
        return constant;
    }
}
