package com.larryhsiao.clotho.currency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

class CurrencySymbolTest {
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
            "US\$",
            CurrencySymbol("USD", Locale.TAIWAN).value()
        )
    }

    @Test
    fun usd_french() {
        assertEquals(
            "\$US",
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
            "JP¥",
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
            "元",
            CurrencySymbol("CNY", Locale.JAPAN).value()
        )
    }

    @Test
    fun rub_ruRU() {
        assertEquals(
            "₽",
            CurrencySymbol("RUB", Locale("ru", "RU")).value()
        )
    }

    @Test
    fun emptyValues() {
        assertEquals(
            "",
            CurrencySymbol("", Locale("")).value()
        )
    }

    @Test
    fun nonExistCode() {
        assertEquals(
            "IDBCCCC",
            CurrencySymbol("IDBCCCC", Locale("")).value()
        )
    }
}