package com.silverhetch.clotho.file;

import com.silverhetch.clotho.Source;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Source to find out that given file is a image or not.
 */
public class IsImage implements Source<Boolean> {
    private final File file;

    public IsImage(File file) {
        this.file = file;
    }

    @Override
    public Boolean value() {
        try {
            final String contentType = Files.probeContentType(file.toPath());
            return contentType != null && contentType.startsWith("image");
        } catch (IOException e) {
            return false;
        }
    }
}
