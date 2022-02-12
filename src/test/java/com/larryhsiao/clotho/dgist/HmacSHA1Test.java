package com.larryhsiao.clotho.dgist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * Test for {@link HmacSHA1}.
 */
public class HmacSHA1Test {
    /**
     * Normal case
     */
    @Test
    void normal() throws Exception {
        Assertions.assertEquals(
            "565a8e07219d855978015554920f01856470e158",
            new HexString(
                new HmacSHA1(
                    () -> "ABC".getBytes(StandardCharsets.UTF_8),
                    "ThisIsSecretKey"
                ).value()
            ).value()
        );
    }
}
