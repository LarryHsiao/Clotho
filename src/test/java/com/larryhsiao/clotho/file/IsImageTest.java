package com.larryhsiao.clotho.file;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit-test for the class {@link IsImage}
 */
public class IsImageTest {
    /**
     * Image file
     */
    @Test
    public void simple() {
        assertTrue(new IsImage(new File("image.png")).value());
        assertTrue(new IsImage(new File("image.jpg")).value());
        assertFalse(new IsImage(new File("image.abc")).value());
        assertFalse(new IsImage(new File("image")).value());
    }
}