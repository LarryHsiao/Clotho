package com.larryhsiao.clotho.file;

import com.larryhsiao.clotho.Source;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Source to find the mimeType of file.
 * Note that this may be slow if the file name have no extension that this source
 * will open connection to the given file.
 */
public class FileMimeType implements Source<String> {
    private final File file;

    public FileMimeType(File file) {
        this.file = file;
    }

    @Override
    public String value() {
        try {
            final String byFiles = Files.probeContentType(file.toPath());
            if (byFiles != null && !byFiles.isEmpty()) {
                return byFiles;
            }
            return file.toURI().toURL().openConnection().getContentType();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
