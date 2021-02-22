package com.larryhsiao.clotho.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.util.Locale.ENGLISH;
import static org.junit.Assert.*;

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
     * Normal case in Taiwan.
     */
    @Test
    public void weekdayIndicatorTaiwan() throws Exception {
        assertEquals(
            "週二",
            new WeekdayString(
                new SimpleDateFormat("dd/MM/yyyy", ENGLISH).parse("23/02/2021"),
                Locale.TAIWAN
            ).value()
        );
    }
}