package com.silverhetch.elizabeth.log

import com.silverhetch.clotho.log.Log

/**
 * Using ANSI escape codes to color the logs. Note that not every terminal support ANSI codes.
 *
 * Using ANSI_RESET to apply default style but our color to avoid the conflict of colors.
 */
class ANSIColorLog(private val log: Log) : Log {
    companion object {
        const val ANSI_RESET = "\u001B[0m"
        const val ANSI_RED = "\u001B[31m"
        const val ANSI_YELLOW = "\u001B[33m"
        const val ANSI_BLUE = "\u001B[34m"
        const val ANSI_CYAN = "\u001B[36m"
    }

    override fun warning(p0: String?) {
        log.warning("$ANSI_YELLOW$p0$ANSI_RESET")
    }

    override fun info(p0: String?) {
        log.info("$ANSI_CYAN$p0$ANSI_RESET")
    }

    override fun error(p0: String?) {
        log.error("$ANSI_RED$p0$ANSI_RESET")
    }

    override fun debug(p0: String?) {
        log.debug("$ANSI_BLUE$p0$ANSI_RESET")
    }
}