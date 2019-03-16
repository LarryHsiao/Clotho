package com.silverhetch.clotho.utility

import com.silverhetch.clotho.Source
import com.silverhetch.clotho.connection.WebRequest

/**
 * [Source] wrapper for [WebRequest]
 */
class HttpSource(private val api: WebRequest) : Source<String> {
    override fun value(): String {
        return String(api.request().bodyBytes)
    }
}