package com.larryhsiao.clotho.time;

import com.larryhsiao.clotho.Source;

/**
 * Source to build a number of millisecond for current time.
 */
public class CurrentTimeSource implements Source<Long> {
    @Override
    public Long value() {
        return System.currentTimeMillis();
    }
}
