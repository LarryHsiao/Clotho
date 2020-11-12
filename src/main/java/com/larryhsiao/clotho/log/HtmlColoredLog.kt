package com.larryhsiao.clotho.log

/**
 * Decorator to make log colorful with html tags.
 */
class HtmlColoredLog(private val log: Log) : Log {

    override fun info(s: String) {
        log.info("<small><font color=\"green\">$s</small></font>")
    }

    override fun debug(s: String) {
        log.debug("<small><font color=\"blue\">$s</small></font>")
    }

    override fun warning(s: String) {
        log.warning("<small><font color=\"yellow\">$s</small></font>")
    }

    override fun error(s: String) {
        log.error("<small><font color=\"red\">$s</small></font>")
    }
}
