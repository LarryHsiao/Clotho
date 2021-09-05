package com.larryhsiao.clotho.file;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link UriFileName}.
 */
class UriFileNameTest {
    /**
     * Check normal uri with file name
     */
    @Test
    void normalCase() {
        assertEquals(
            "abc.txt",
            new UriFileName(
                "content://path.com/abc.txt"
            ).value()
        );
    }

    /**
     * Check uri with file name only
     */
    @Test
    void noExtension() {
        assertEquals(
            "abc",
            new UriFileName(
                "content://path.com/abc"
            ).value()
        );
    }

    /**
     * Check uri with long path
     */
    @Test
    void longPath() {
        assertEquals(
            "abc",
            new UriFileName(
                "content://path.com/long/long/path/abc"
            ).value()
        );
    }

    /**
     * Check the behavior of invalid uri.
     */
    @Test
    void invalidUri() {
        assertEquals(
            "abc",
            new UriFileName(
                "/path.com/long/long/path/abc"
            ).value()
        );
    }
}