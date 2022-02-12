package com.larryhsiao.clotho.dgist;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link MD5}.
 */
class MD5Test {
    @Test
    void normalCase() throws Exception {
        assertEquals(
            "a43c1b0aa53a0c908810c06ab1ff3967",
            new MD5(new ByteArrayInputStream("input".getBytes())).value()
        );
    }
}