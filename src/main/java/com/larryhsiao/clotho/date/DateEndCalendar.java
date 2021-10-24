package com.larryhsiao.clotho.date;

import com.larryhsiao.clotho.Source;

import java.util.Calendar;

/**
 * Source to generate Calendar which time is 23:59 of the given timestamp.
 */
public class DateEndCalendar implements Source<Calendar> {
    private final long millis;
    private final Calendar calendar;

    public DateEndCalendar(long millis) {
        this(millis, Calendar.getInstance());
    }

    public DateEndCalendar(long millis, Calendar calendar) {
        this.millis = millis;
        this.calendar = calendar;
    }

    @Override
    public Calendar value() {
        calendar.setTimeInMillis(millis);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }
}
