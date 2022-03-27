package com.larryhsiao.clotho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link ConstSource}.
 */
class ConstSourceTest {
    @Test
    void inputEqualsOutput() throws Exception {
        final Object object = new Object();
        Assertions.assertEquals(
            object,
            new ConstSource<>(object).value()
        );
    }
}