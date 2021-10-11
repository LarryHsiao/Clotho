package com.larryhsiao.clotho.source;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link ConstSource}
 */
public class ConstSourceTest {
    /**
     * Check output
     */
    @Test
    void normal() {
        Assertions.assertEquals(
            "TestString",
            new ConstSource<>("TestString").value()
        );
    }
}
