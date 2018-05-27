package com.silverhetch.elizabeth.arch

import com.silverhetch.clotho.connection.WebRequest

class HttpSource(private val api: WebRequest) : Source<String> {
    override fun fetch(): String {
        return String(api.request().bodyBytes)
    }
}