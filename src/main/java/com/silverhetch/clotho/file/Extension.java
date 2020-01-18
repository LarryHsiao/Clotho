package com.silverhetch.clotho.file;

import com.silverhetch.clotho.Source;

import java.io.File;

/**
 * Source to find extension from url.
 */
public class Extension implements Source<String> {
    private final File file;

    public Extension(File file) {
        this.file = file;
    }

    @Override
    public String value() {
        if (file.isDirectory()) {
            return "";
        }
        final String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf+1);
    }
}
