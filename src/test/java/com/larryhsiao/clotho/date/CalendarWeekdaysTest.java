package com.larryhsiao.clotho.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link JdkWeekdays}.
 */
public class CalendarWeekdaysTest {
    /**
     * Check the days number.
     */
    @Test
    public void dayCount() {
        Assertions.assertEquals(
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
        Assertions.assertEquals("Mon", days[0].name());
        Assertions.assertEquals("Tue", days[1].name());
        Assertions.assertEquals("Wed", days[2].name());
        Assertions.assertEquals("Thu", days[3].name());
        Assertions.assertEquals("Fri", days[4].name());
        Assertions.assertEquals("Sat", days[5].name());
        Assertions.assertEquals("Sun", days[6].name());
    }
}