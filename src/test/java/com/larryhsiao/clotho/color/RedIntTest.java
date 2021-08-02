package com.larryhsiao.clotho.color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link RedInt}
 */
public class RedIntTest {
    /**
     * Normal case
     */
    @Test
    void normalCase() {
        assertEquals(
            160,
            new RedInt(0xA0ffff).value()
        );
    }
}
