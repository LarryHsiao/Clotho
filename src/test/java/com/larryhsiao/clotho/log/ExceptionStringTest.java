package com.larryhsiao.clotho.log;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link ExceptionString}
 */
class ExceptionStringTest {
    /**
     * Check if the source have any output.
     */
    @Test
    void checkIfAnyOutput() {
        assertNotEquals("", new ExceptionString(new Exception("test")).value());
    }
}