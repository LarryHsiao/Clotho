package com.larryhsiao.clotho.date;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

/**
 * Test for {@link JdkWeekdays}.
 */
public class CalendarWeekdaysTest {
    /**
     * Check the days number.
     */
    @Test
    public void dayCount() {
        Assert.assertEquals(
            7,
            new JdkWeekdays().days().length
        );
    }

    /**
     * Check the weekday names.
     */
    @Test
    public void dayNameInEnglish() {
        final Weekday[] days = new JdkWeekdays().days();
        Assert.assertEquals("Mon", days[0].name());
        Assert.assertEquals("Tue", days[1].name());
        Assert.assertEquals("Wed", days[2].name());
        Assert.assertEquals("Thu", days[3].name());
        Assert.assertEquals("Fri", days[4].name());
        Assert.assertEquals("Sat", days[5].name());
        Assert.assertEquals("Sun", days[6].name());
    }
}