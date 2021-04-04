package com.larryhsiao.clotho.utility.comparator;

import java.io.File;
import java.util.Comparator;

/**
 * Compare two file with type.
 */
public class FileComparator implements Comparator<File> {
    private final Comparator<File> origin;

    public FileComparator(Comparator<File> origin) {
        this.origin = origin;
    }

    public FileComparator() {
        this.origin = (o1, o2) -> 0;
    }

    @Override
    public int compare(File o1, File o2) {
        if (o1.isDirectory() && !o2.isDirectory()) {
            return -1;
        } else if (!o1.isDirectory() && o2.isDirectory()) {
            return 1;
        } else {
            return origin.compare(o1, o2);
        }
    }
}