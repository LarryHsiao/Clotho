package com.silverhetch.clotho.regex;

import com.silverhetch.clotho.Source;
import com.silverhetch.clotho.log.Log;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Source to determine the given string is url or not
 */
public class IsUrl implements Source<Boolean> {
    private final String url;
    private final Log log;

    public IsUrl(String url, Log log) {
        this.url = url;
        this.log = log;
    }

    @Override
    public Boolean value() {
        try {
            new URL(url);
            log.debug("Url: " + url);
            return true;
        } catch (MalformedURLException e) {
            log.debug("No a url: " + url);
            return false;
        }
    }
}
