package com.silverhetch.clotho.regex;

import com.silverhetch.clotho.log.BeautyLog;
import com.silverhetch.clotho.log.Log;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit-test for the class {@link IsUrl}
 */
public class IsUrlTest {
    private final Log log = new BeautyLog().value();

    @Test
    public void normal() {
        assertTrue(new IsUrl("http://abc.com", log).value());
    }

    @Test
    public void customProtocol() {
        assertFalse(new IsUrl("abc://abc.com", log).value());
    }

    @Test
    public void missingProtocol() {
        assertFalse(new IsUrl("abc.com", log).value());
    }
}