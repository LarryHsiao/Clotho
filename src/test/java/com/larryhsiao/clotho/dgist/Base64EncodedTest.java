package com.larryhsiao.clotho.dgist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * Test for {@link Base64Encoded}.
 */
public class Base64EncodedTest {
    /**
     * Check output
     */
    @Test
    void normal() {
        Assertions.assertEquals(
            "QUJD",
            new Base64Encoded(() -> "ABC".getBytes(StandardCharsets.UTF_8)).value()
        );
    }
}
