package com.larryhsiao.clotho.date;

import com.larryhsiao.clotho.Source;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Decorator to find the given date range in millisecond,
 * Just make the range to cover entire of day as possible.
 */
public class DateRangeSource implements Source<long[]> {
    private final TimeZone timeZone;
    private final Source<long[]> rangeSrc;

    /**
     * @param rangeSrc The given range in milliseconds,
     *                 First one is Ended Date,
     *                 and the seconds one is Started date.
     */
    public DateRangeSource(TimeZone timeZone, Source<long[]> rangeSrc) {
        this.timeZone = timeZone;
        this.rangeSrc = rangeSrc;
    }

    @Override
    public long[] value() {
        final long[] range = rangeSrc.value();
        final long[] result = new long[2];
        final Calendar first = Calendar.getInstance(timeZone);
        first.setTime(new Date(range[0]));
        first.set(Calendar.HOUR_OF_DAY, 0);
        first.set(Calendar.MINUTE, 0);
        first.set(Calendar.SECOND, 0);
        result[0] = first.getTimeInMillis();

        final Calendar second = Calendar.getInstance(timeZone);
        second.setTime(new Date(range[1]));
        second.set(Calendar.HOUR_OF_DAY, 23);
        second.set(Calendar.MINUTE, 59);
        second.set(Calendar.SECOND, 59);
        result[1] = second.getTimeInMillis();
        return result;
    }
}
