package com.larryhsiao.clotho.color;

import com.larryhsiao.clotho.Source;

/**
 * Extract blue int in color int
 */
public class RedInt implements Source<Long> {
    private final long color;

    public RedInt(long color) {this.color = color;}

    @Override
    public Long value() {
        return (color >> 16) & 0xff;
    }
}
