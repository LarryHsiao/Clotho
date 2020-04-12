package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.text.NumberFormat
import kotlin.Long.Companion.MAX_VALUE

/**
 * Source to build size indicator string.
 */
class SizeText(private val sizeSrc: Source<Long>) : Source<String?> {
    companion object {
        private const val BYTES_TB = 1099511627776
        private const val BYTES_GB = 1073741824
        private const val BYTES_MB = 1048576
        private const val BYTES_KB = 1024
    }

    override fun value(): String {
        val format = NumberFormat.getInstance()
        format.maximumFractionDigits = 1
        return when (val count = sizeSrc.value()) {
            in BYTES_KB until BYTES_MB -> {
                format.format(count / BYTES_KB.toDouble()) + " KB"
            }
            in BYTES_MB until BYTES_GB -> {
                format.format(count / BYTES_MB.toDouble()) + " MB"
            }
            in BYTES_GB until BYTES_TB -> {
                format.format(count / BYTES_GB.toDouble()) + " GB"
            }
            in BYTES_TB until MAX_VALUE -> {
                format.format(count / BYTES_TB.toDouble()) + " TB"
            }
            else -> {
                "$count"
            }
        }
    }
}