package com.silverhetch.clotho.currency

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class CurrencySymbolTest{
    @Test
    fun usd_us() {
        assertEquals(
            "$",
            CurrencySymbol("USD", Locale.US).value()
        )
    }

    @Test
    fun usd_tw() {
        assertEquals(
            "USD",
            CurrencySymbol("USD", Locale.TAIWAN).value()
        )
    }


    @Test
    fun usd_french() {
        assertEquals(
            "USD",
            CurrencySymbol("USD", Locale.FRENCH).value()
        )
    }

    @Test
    fun usd_canada() {
        assertEquals(
            "US\$",
            CurrencySymbol("USD", Locale.CANADA).value()
        )
    }

    @Test
    fun jpy_japan() {
        assertEquals(
            "￥",
            CurrencySymbol("JPY", Locale.JAPAN).value()
        )
    }

    @Test
    fun jpy_china() {
        assertEquals(
            "JPY",
            CurrencySymbol("JPY", Locale.CHINA).value()
        )
    }

    @Test
    fun cny_china() {
        assertEquals(
            "￥",
            CurrencySymbol("CNY", Locale.CHINA).value()
        )
    }

    @Test
    fun cny_japan() {
        assertEquals(
            "CNY",
            CurrencySymbol("CNY", Locale.JAPAN).value()
        )
    }

    @Test
    fun rub_ruRU() {
        assertEquals(
            "руб.",
            CurrencySymbol("RUB", Locale("ru","RU")).value()
        )
    }
}