package com.silverhetch.elizabeth.log

import com.silverhetch.clotho.log.Log

class TagLog(private val log:Log) : Log {
    override fun warning(p0: String?) {
        log.warning("[WARN]: $p0")
    }

    override fun info(p0: String?) {
        log.info("[INFO]: $p0")
    }

    override fun error(p0: String?) {
        log.error("[ERROR]: $p0")
    }

    override fun debug(p0: String?) {
        log.debug("[DEBUG]: $p0")
    }
}