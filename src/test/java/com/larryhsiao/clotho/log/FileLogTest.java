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
     * Check file content is same with all log method.
     */
    @Test
    void fileContentAll() throws IOException {
        final File tempDir = Files.createTempDirectory("test").toFile();
        final File logFile = new File(tempDir, "temp.log");
        final FileLog log = new FileLog(logFile.getAbsolutePath());
        log.open();
        log.info("This is a new Line");
        log.warning("This is a new Line");
        log.error("This is a new Line");
        log.debug("This is a new Line");
        log.close();
        assertEquals(
            "This is a new Line\nThis is a new Line\nThis is a new Line\nThis is a new Line",
            new FileText(logFile).value()
        );
    }

    /**
     * Append to exist log file if path exist.
     */
    @Test
    void appendToExistOne() throws IOException {
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

    /**
     * Check not throw exception when file is not valid calling open/close.
     */
    @Test
    void notCrashIfCanNotLog() {
        final FileLog log = new FileLog(new File("/").getAbsolutePath());
        log.open();
        log.close();
        assertTrue(true);
    }

    /**
     * Check it should create new log file if size limit reached
     */
    @Test
    void contentLargerThenSizeLimit() throws IOException {
        final File tempDir = Files.createTempDirectory("test").toFile();
        final File logFile = new File(tempDir, "temp.log");
        final FileLog log = new FileLog(new SystemPrintLog(), logFile.getAbsolutePath(), 1);
        log.open();
        log.info("This is a new Line");
        log.info("This is a new Line"); // Create new file because the log file reach the limit.
        log.close();
        assertEquals(2, tempDir.list().length);
    }

    /**
     * No exception if file deleted.
     */
    @Test
    void fileDeleted() throws IOException {
        final File tempDir = Files.createTempDirectory("test").toFile();
        final File logFile = new File(tempDir, "temp.log");
        final FileLog log = new FileLog(logFile.getAbsolutePath());
        log.open();
        logFile.delete();
        log.info("This is a new Line");
        log.close();
        assertTrue(true);
    }

    /**
     * No exception when file path not valid
     */
    @Test
    void notValidPath() {
        final FileLog log = new FileLog(new File("/abc").getAbsolutePath());
        log.open();
        log.close();
        assertTrue(true);
    }
}