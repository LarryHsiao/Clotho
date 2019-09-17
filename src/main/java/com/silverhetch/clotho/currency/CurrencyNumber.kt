package com.silverhetch.clotho.currency

import com.silverhetch.clotho.Source
import java.lang.Exception
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

/**
 * Number that formats currency number by Locale.
 */
class CurrencyNumber(
    private val value: BigDecimal,
    private val targetCurrency: Currency,
    private val display: Locale
) : Source<String> {
    override fun value(): String {
        return try {
            DecimalFormat.getCurrencyInstance(display).apply {
                currency = targetCurrency
            }.format(value)
        } catch (e: Exception) {
            e.printStackTrace()
            value.stripTrailingZeros().toString()
        }
    }
}