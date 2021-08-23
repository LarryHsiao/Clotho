package com.larryhsiao.clotho.color;

import com.larryhsiao.clotho.Source;

/**
 * Extract blue int in color int
 */
public class BlueInt implements Source<Long> {
    private final long color;

    public BlueInt(long color) {this.color = color;}

    @Override
    public Long value() {
        return color & 0xff;
    }
}
