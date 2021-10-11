package com.larryhsiao.clotho.identity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Test for {@link RevertedUUID}.
 */
public class RevertedUUIDTest {
     /**
     * Check the uuid is revert properly.
     */
    @Test
    void normal() {
        Assertions.assertEquals(
            "07d4a697-ece5-18a7-d647-ca12730cc5e6",
            new RevertedUUID(
                UUID.fromString("e6c50c73-12ca-47d6-a718-e5ec97a6d407")
            ).value().toString()
        );
    }
}
