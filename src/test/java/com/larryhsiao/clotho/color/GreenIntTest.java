package com.larryhsiao.clotho.color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link GreenInt}
 */
public class GreenIntTest {
    /**
     * Normal case
     */
    @Test
    void normalCase() {
        assertEquals(
            160,
            new GreenInt(0xFFA0FF).value()
        );
    }
}
