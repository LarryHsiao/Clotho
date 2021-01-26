package com.larryhsiao.clotho.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

/**
 * Tests for {@link StringOutput}
 */
public class StringOutputTest {

    /**
     * Check if the actual output is same as input.
     */
    @Test
    public void checkOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new StringOutput("Content", output).fire();
        Assert.assertEquals("Content", new String(output.toByteArray()));
    }
}