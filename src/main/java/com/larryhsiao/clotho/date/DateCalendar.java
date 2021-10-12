package com.larryhsiao.clotho.date;

import com.larryhsiao.clotho.Source;

import java.util.Calendar;

/**
 * Source to generate Calendar which time is 00:00 am of the given timestamp.
 */
public class DateCalendar implements Source<Calendar> {
    private final long millis;
    private final Calendar calendar;

    public DateCalendar(long millis) {
        this(millis, Calendar.getInstance());
    }

    public DateCalendar(long millis, Calendar calendar) {
        this.millis = millis;
        this.calendar = calendar;
    }

    @Override
    public Calendar value() {
        calendar.setTimeInMillis(millis);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }
}
