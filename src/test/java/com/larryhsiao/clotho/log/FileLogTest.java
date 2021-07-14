package com.larryhsiao.clotho.log;

import com.larryhsiao.clotho.file.FileText;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link FileLog}
 */
class FileLogTest {
    /**
     * Check file content is same.
     */
    @Test
    void fileContent() throws IOException {
        final File tempDir = Files.createTempDirectory("test").toFile();
        final File logFile = new File(tempDir, "temp.log");
        final FileLog log = new FileLog(logFile.getAbsolutePath());
        log.open();
        log.info("This is a new Line");
        log.close();
        assertEquals(
           "This is a new Line",
           new FileText(logFile).value()
        );
    }

    /**
     * Append to exist log file if path exist.
     */
    @Test
    void appendToExistOne() throws IOException{
        final File tempDir = Files.createTempDirectory("test").toFile();
        final File logFile = new File(tempDir, "temp.log");
        final FileLog log = new FileLog(logFile.getAbsolutePath());
        log.open();
        log.info("This is a new Line");
        log.close();
        log.open();
        log.info("This is a new Line");
        log.close();
        assertEquals(
            "This is a new Line\nThis is a new Line",
            new FileText(logFile).value()
        );
        assertEquals(1, tempDir.list().length);
    }
}