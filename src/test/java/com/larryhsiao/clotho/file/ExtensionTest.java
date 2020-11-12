package com.larryhsiao.clotho.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Unit-test for the class {@link Extension}
 */
public class ExtensionTest {

    /**
     * Check the output
     */
    @Test
    public void simple() {
        Assert.assertEquals("png", new Extension(new File("abc.png")).value());
    }

    /**
     * Check the output without extension.
     */
    @Test
    public void empty() {
        Assert.assertEquals("", new Extension(new File("abc/baf")).value());
    }

    /**
     * Empty extension of directory
     */
    @Test
    public void directory() throws IOException {
        Assert.assertEquals(
            "",
            new Extension(Files.createTempDirectory("").toFile()).value()
        );
    }
}