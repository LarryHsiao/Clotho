package com.silverhetch.clotho.currency

import com.silverhetch.clotho.Source
import java.lang.Exception
import java.util.*

/**
 * Utility to get currency symbol, return input code back if not a ISO 4217 code.
 *
 * @param code The ISO 4217 currency code.
 */
class CurrencySymbol(private val code: String, private val displayLocale: Locale = Locale.getDefault()) : Source<String> {
    override fun value(): String {
        return try {
            Currency.getInstance(code).getSymbol(displayLocale)
        } catch (ignore: Exception) {
            code
        }
    }
}