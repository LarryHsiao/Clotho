package com.larryhsiao.clotho.date;

import com.larryhsiao.clotho.Source;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.SHORT;

/**
 * Source to build a string to indicates the day of the week with given date.
 */
public class WeekdayString implements Source<String> {
    private final Date date;
    private final Locale locale;

    public WeekdayString(Date date) {
        this(date, Locale.ENGLISH);
    }

    public WeekdayString(Date date, Locale locale) {
        this.date = date;
        this.locale = locale;
    }

    @Override
    public String value() {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.getDisplayName(DAY_OF_WEEK, SHORT, locale);
    }
}
