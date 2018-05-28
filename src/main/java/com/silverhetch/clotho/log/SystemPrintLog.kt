package com.silverhetch.clotho.log

import com.silverhetch.clotho.log.Log

/**
 * Log using system print.
 */
class SystemPrintLog : Log {
    override fun warning(p0: String?) {
        System.out.println("$p0")
    }

    override fun info(p0: String?) {
        System.out.println("$p0")
    }

    override fun error(p0: String?) {
        System.out.println("$p0")
    }

    override fun debug(p0: String?) {
        System.out.println("$p0")
    }
}