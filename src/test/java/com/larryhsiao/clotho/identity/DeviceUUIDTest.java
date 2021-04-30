package com.larryhsiao.clotho.identity;

import com.larryhsiao.clotho.file.FileText;
import com.larryhsiao.clotho.file.TextFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link DeviceUUID}
 */
class DeviceUUIDTest {

    /**
     * Check if file exist after first time fetch the device uuid.
     */
    @Test
    void createNewOne() throws Exception {
        final File rootFile = Files.createTempDirectory("pref").toFile();
        new DeviceUUID(rootFile).value();
        assertTrue(rootFile.exists());
        assertNotEquals(
            "",
            new FileText(
                new File(rootFile, "uuid.txt")
            ).value()
        );
    }

    /**
     * Throw exception when the exist uuid file contains invalided String.
     */
    @Test
    void throwExceptionWhenTextFileNotUuid() throws Exception {
        try {
            final File rootFile = Files.createTempDirectory("pref").toFile();
            new TextFile(new File(rootFile, "uuid.txt"), "").value();
            new DeviceUUID(rootFile).value();
            fail();
        } catch (Exception e) {
            Assertions.assertEquals("Invalid UUID string: ", e.getMessage());
        }
    }

    /**
     * Check if the uuid changed after created.
     */
    @Test
    void uuidNotChangedAfterCreate() throws Exception{
        final File rootFile = Files.createTempDirectory("pref").toFile();
        Assertions.assertEquals(
            new DeviceUUID(rootFile).value(),
            new DeviceUUID(rootFile).value()
        );
    }
}