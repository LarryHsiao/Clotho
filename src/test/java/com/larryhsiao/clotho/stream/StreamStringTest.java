package com.larryhsiao.clotho.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

/**
 * Test for [StreamString].
 */
public class StreamStringTest {

    /**
     * Check the output is equal as expect.
     */
    @Test
    void normal() {
        Assertions.assertEquals(
            "Test",
            new StreamString(
                new ByteArrayInputStream("Test".getBytes())
            ).value()
        );
    }
}
