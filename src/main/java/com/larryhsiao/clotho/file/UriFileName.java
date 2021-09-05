package com.larryhsiao.clotho.file;

import com.larryhsiao.clotho.Source;

import java.io.File;
import java.net.URI;

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
