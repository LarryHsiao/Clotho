package com.larryhsiao.clotho.time;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit-test for the class {@link HttpTimeFormat}
 */
public class HttpTimeFormatTest {
    @Test
    public void format() {
        final Date date = new Date();
        date.setTime(0);
        assertEquals(
            "Thu, 01 Jan 1970 00:00:00 UTC",
            new HttpTimeFormat(Locale.US).value().format(date)
        );
    }

    @Test
    public void parse() throws ParseException {
        final String raw = "Thu, 01 Jan 1970 00:00:00 GMT";
        assertEquals(
            0,
            new HttpTimeFormat().value().parse(raw).getTime()
        );
    }
}