package com.larryhsiao.clotho.comparator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringComparatorTest {
    /**
     * If the string is the same
     */
    @SuppressWarnings("EqualsWithItself")
    @Test
    void checkEqual() {
        assertEquals(
            0,
            new StringComparator().compare("1", "1")
        );
    }

    /**
     * If the string is not the same
     */
    @Test
    void simple() {
        assertEquals(
            1,
            new StringComparator().compare("2", "1")
        );
    }

    /**
     * Check the reserved order.
     */
    @Test
    void simple_reversed() {
        assertEquals(
            -1,
            new StringComparator().reversed().compare("2", "1")
        );
    }
}
