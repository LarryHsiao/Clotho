package com.larryhsiao.clotho.regex;

import com.larryhsiao.clotho.log.BeautyLog;
import com.larryhsiao.clotho.log.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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