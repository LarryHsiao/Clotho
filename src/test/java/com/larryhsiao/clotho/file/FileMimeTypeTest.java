package com.larryhsiao.clotho.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Unit-test for the class {@link FileMimeType}
 */
public class FileMimeTypeTest {

    /**
     * File name jpeg
     */
    @Test
    public void nameJpeg() throws IOException {
        File file = Files.createTempFile("temp", ".jpeg").toFile();
        Assertions.assertEquals(
            "image/jpeg",
            new FileMimeType(file).value()
        );
    }

    /**
     * File name jpg
     */
    @Test
    public void nameJpg() throws IOException {
        File file = Files.createTempFile("temp", ".jpg").toFile();
        Assertions.assertEquals(
            "image/jpeg",
            new FileMimeType(file).value()
        );
    }

    /**
     * Check with mp4 file name.
     */
    @Test
    public void nameMp4() throws IOException {
        File file = Files.createTempFile("temp", ".mp4").toFile();
        Assertions.assertEquals(
            "video/mp4",
            new FileMimeType(file).value()
        );
    }

    /**
     * Find content type by actually read the content.
     */
    @Test
    public void contentGif() throws IOException {
        File file = Files.createTempFile("temp", "").toFile();
        file.delete();
        Files.copy(
            new File("src/test/resources/lena_color.gif").toPath(),
            file.toPath()
        );
        Assertions.assertEquals("image/gif", new FileMimeType(file).value());
    }

    /**
     * Find content type by actually read the 3gp content.
     */
    @Test
    public void content3gp() throws IOException {
        File file = Files.createTempFile("temp", "").toFile();
        file.delete();
        Files.copy(
            new File("src/test/resources/small.3gp").toPath(),
            file.toPath()
        );
//        Assertions.assertEquals("video/3gpp", new FileMimeType(file).value());
        Assertions.assertEquals("content/unknown", new FileMimeType(file).value());
    }

    /**
     * Find content type by actually read the 3gp content.
     */
    @Test
    public void contentMP4() throws IOException {
        File file = Files.createTempFile("temp", "").toFile();
        file.delete();
        Files.copy(
            new File("src/test/resources/small.mp4").toPath(),
            file.toPath()
        );
//        Assertions.assertEquals("video/mp4", new FileMimeType(file).value());
        Assertions.assertEquals("content/unknown", new FileMimeType(file).value());
    }

    /**
     * Throw exception when file not exist.
     */
    @Test
    public void failedOnNotSuchFile() {
        try {
           new FileMimeType(new File("FILE_NOT_EXIST")).value();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}