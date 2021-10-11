package com.larryhsiao.clotho.dgist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * Test for hex given string
 */
public class HexStringTest {
    /**
     * Normal case
     */
    @Test
    void normal() {
        Assertions.assertEquals(
            "414243",
            new HexString("ABC".getBytes(StandardCharsets.UTF_8)).value()
        );
    }
}
