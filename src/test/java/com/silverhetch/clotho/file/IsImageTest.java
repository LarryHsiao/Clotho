package com.silverhetch.clotho.file;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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