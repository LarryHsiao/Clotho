package com.larryhsiao.clotho.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test for {@link StreamClosing}.
 */
class StreamClosingTest {
    /**
     * Just close it.
     */
    @Test
    void closeNormally() {
        try {
            new StreamClosing(() -> {}).fire();
            Assertions.assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * No exception throwing when close method throws one.
     */
    @Test
    void noException() {
        try {
            new StreamClosing(() -> {
                throw new IOException();
            }).fire();
            Assertions.assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }
}