package com.larryhsiao.clotho.currency

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.math.BigDecimal
import java.util.*

/**
 * Notice: The result might changed in different version of JDK.
 * Had check the result on open JDK 11, that this test will failed on JDK 8 or other implementation.
 */
class CurrencyNumberTest {
    @Test
    fun jpy_japan() {
        assertEquals(
            "￥1,000",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("JPY"),
                Locale.JAPAN
            ).value()
        )
    }

    @Test
    fun usd_us() {
        assertEquals(
            "\$1,000.00",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("USD"),
                Locale.US
            ).value()
        )
    }

    @Test
    fun usd_canada() {
        assertEquals(
            "US\$1,000.00",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("USD"),
                Locale.CANADA
            ).value()
        )
    }

    @Test
    fun twd_tw() {
        assertEquals(
            "\$1,000.00",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("TWD"),
                Locale.TAIWAN
            ).value()
        )
    }

    @Test
    fun twd_us() {
        assertEquals(
            "NT\$1,000.00",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("TWD"),
                Locale.US
            ).value()
        )
    }

    /**
     * For AED in ar_AE.
     *
     * @todo #currency-0 Make sure the numbers is in use in real world
     */
    @Test
    fun aed_arAE() {
        assertEquals(
            "د.إ.\u200F ١٬٠٠٠٫٠٠",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("AED"),
                Locale("ar", "AE")
            ).value()
        )
    }

    @Test
    fun usd_french() {
        assertEquals(
            "1 000,00 \$US",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("USD"),
                Locale.FRENCH
            ).value()
        )
    }

    @Test
    fun usd_arAE() {
        assertEquals(
            "US\$ ١٬٠٠٠٫٠٠",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("USD"),
                Locale("ar", "AE")
            ).value()
        )
    }

    @Test
    fun sar_arSA() {
        assertEquals(
            "ر.س.\u200F ١٬٠٠٠٫٠٠",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("SAR"),
                Locale("ar", "SA")
            ).value()
        )
    }

    @Test
    fun rub_ruRU() {
        assertEquals(
            "1 000,00 ₽",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("RUB"),
                Locale("ru", "RU")
            ).value()
        )
    }

    @Test
    fun uah_ukUA() {
        assertEquals(
            "1 000,00 ₴",
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("UAH"),
                Locale("uk", "UA")
            ).value()
        )
    }

    @Test
    fun uah_ukUA_endWithSymbol() {
        assertTrue(
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("UAH"),
                Locale("uk", "UA")
            ).value().endsWith(
                Currency.getInstance("UAH")
                    .getSymbol(Locale("uk", "UA"))
            )
        )
    }

    @Test
    fun nonExist() {
        assertTrue(
            CurrencyNumber(
                BigDecimal.valueOf(1000),
                Currency.getInstance("UAH"),
                Locale("uk", "UA")
            ).value().endsWith(
                Currency.getInstance("UAH")
                    .getSymbol(Locale("uk", "UA"))
            )
        )
    }
}