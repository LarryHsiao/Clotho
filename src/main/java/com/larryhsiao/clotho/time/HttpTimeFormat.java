package com.larryhsiao.clotho.time;

import com.larryhsiao.clotho.Source;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import static java.util.Locale.US;

/**
 * Time format that follows the RFC-7232
 *
 * @see "https://tools.ietf.org/html/rfc7232#section-3.3"
 */
public class HttpTimeFormat implements Source<DateFormat> {
    private final Locale locale;

    public HttpTimeFormat(Locale locale) {
        this.locale = locale;
    }

    public HttpTimeFormat() {
        this(US);
    }

    @Override
    public DateFormat value() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss z", locale
        );
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat;
    }
}
