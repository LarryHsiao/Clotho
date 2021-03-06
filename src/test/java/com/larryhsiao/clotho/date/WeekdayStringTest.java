package com.larryhsiao.clotho.date;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

import static java.util.Locale.ENGLISH;
import static java.util.Locale.TAIWAN;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link WeekdayString}.
 */
public class WeekdayStringTest {

    /**
     * Normal case in English.
     */
    @Test
    public void theIndicatorEnglish() throws Exception {
        assertEquals(
            "Tue",
            new WeekdayString(
                new SimpleDateFormat("dd/MM/yyyy", ENGLISH).parse("23/02/2021"),
                ENGLISH
            ).value()
        );
    }

    /**
     * Default indicator(English).
     */
    @Test
    public void theIndicatorDefault() throws Exception {
        assertEquals(
            "Tue",
            new WeekdayString(
                new SimpleDateFormat("dd/MM/yyyy", ENGLISH).parse("23/02/2021")
            ).value()
        );
    }

    /**
     * Normal case in Taiwan.
     */
    @Test
    @Disabled
    public void weekdayIndicatorTaiwan() throws Exception {
        assertEquals(
           "週二",
            new WeekdayString(
                new SimpleDateFormat("dd/MM/yyyy", ENGLISH).parse("23/02/2021"),
                TAIWAN
            ).value()
        );
    }
}