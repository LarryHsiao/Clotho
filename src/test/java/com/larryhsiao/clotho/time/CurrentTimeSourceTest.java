package com.larryhsiao.clotho.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link CurrentTimeSource}.
 */
public class CurrentTimeSourceTest {
    /**
     * Test the result is in recently.
     */
    @Test
    public void resultIsRecent() {
        Assertions.assertEquals(
            Double.valueOf(System.currentTimeMillis()),
            new CurrentTimeSource().value(),
           5000
        );
    }
}