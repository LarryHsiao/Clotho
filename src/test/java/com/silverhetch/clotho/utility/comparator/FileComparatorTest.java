package com.silverhetch.clotho.utility.comparator;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Comparator;

/**
 * Unit-test for the class {@link FileComparator}
 */
public class FileComparatorTest {
    /**
     * Check the result
     */
    @Test
    public void simple() throws Exception {
        final File dir = Files.createTempDirectory("prefix").toFile();
        final File dir2 = Files.createTempDirectory("prefix2").toFile();
        final File file = File.createTempFile("prefix", "");
        final File file2 = File.createTempFile("prefix", "2");

        assertEquals(-1, new FileComparator().compare(dir, file));
        assertEquals(1, new FileComparator().compare(file, dir));
        assertEquals(0, new FileComparator().compare(file, file2));
        assertEquals(0, new FileComparator().compare(dir, dir2));
        assertEquals(0, new FileComparator(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return 0;
            }
        }).compare(dir, dir2));
    }
}