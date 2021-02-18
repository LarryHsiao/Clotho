package com.larryhsiao.clotho.time;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for {@link CurrentTimeSource}.
 */
public class CurrentTimeSourceTest {
    /**
     * Test the result is in recently.
     */
    @Test
    public void resultIsRecent() {
        Assert.assertEquals(
            Double.valueOf(System.currentTimeMillis()),
            new CurrentTimeSource().value(),
           5000
        );
    }
}