package com.larryhsiao.clotho.file;

import com.larryhsiao.clotho.Source;
import com.sun.org.apache.xerces.internal.util.URI;

import java.io.File;

/**
 * Source to build file name from given uri.
 */
public class UriFileName implements Source<String> {
    private final String uri;

    public UriFileName(String uri) {
        this.uri = uri;
    }

    @Override
    public String value() {
        try {
            return new File(new URI(uri).getPath()).getName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}