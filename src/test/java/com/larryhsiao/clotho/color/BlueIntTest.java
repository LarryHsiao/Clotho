package com.larryhsiao.clotho.color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link BlueInt}
 */
public class BlueIntTest{
    /**
     * Normal case
     */
    @Test
    void normalCase() {
        assertEquals(
            160,
            new BlueInt(0xFFffA0).value()
        );
    }
}
