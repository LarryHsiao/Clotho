package com.larryhsiao.clotho.color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link LuminanceByColor}.
 */
public class LuminanceByColorTest {
    @Test
    void white() {
        Assertions.assertEquals(
            1.0,
            new LuminanceByColor(0xFFFFFF).value(),
            0.0
        );
    }

    @Test
    void black() {
        Assertions.assertEquals(
            0.0,
            new LuminanceByColor(0x000000).value(),
            0.0
        );
    }

    /**
     * Check Color(127,127,127), the luminance should be 0.4980(255/127)
     */
    @Test
    void color_7f7f7f() {
        Assertions.assertEquals(
            0.4980,
            new LuminanceByColor(0x7f7f7f).value(),
            0.0001
        );
    }
}
