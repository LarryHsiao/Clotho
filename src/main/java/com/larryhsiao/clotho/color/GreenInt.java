package com.larryhsiao.clotho.color;

import com.larryhsiao.clotho.Source;

/**
 * Extract blue int in color int
 */
public class GreenInt implements Source<Long> {
    private final long color;

    public GreenInt(long color) {this.color = color;}

    @Override
    public Long value() {
        return (color >> 8) & 0xff;
    }
}
