package com.larryhsiao.clotho.date;

import java.lang.reflect.Array;
import java.text.DateFormatSymbols;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.SHORT;

/**
 * Weekdays implemented with jdk {@link Calendar}.
 */
public class JdkWeekdays implements Weekdays {
    private final Locale locale;

    public JdkWeekdays() {
        this(Locale.getDefault());
    }

    public JdkWeekdays(Locale locale) {
        this.locale = locale;
    }


    @SuppressWarnings("FuseStreamOperations")
    @Override
    public Weekday[] days() {
        final DateFormatSymbols symbols = new DateFormatSymbols(locale);
        final List<Weekday> list = Arrays.stream(symbols.getShortWeekdays())
            .skip(1)
            .map(ConstWeekday::new)
            .collect(Collectors.toList());
        Collections.rotate(list, -1);
        return list.toArray(new Weekday[list.size()]);
    }
}
