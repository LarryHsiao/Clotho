package com.larryhsiao.clotho.log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link PrintedSource}.
 */
class PrintedSourceTest {

    /**
     * Check if normally return same object.
     */
    @Test
    void normalCase() {
        final String target = "This is the data";
        Assertions.assertEquals(
            target,
            new PrintedSource<>(() -> target).value()
        );
    }
}