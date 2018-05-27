package com.silverhetch.elizabeth.arch.connection

import com.silverhetch.clotho.connection.Target
import com.silverhetch.clotho.connection.WebApi
import java.net.HttpURLConnection

/**
 * Http Get with Headers.
 */
class Get(target: Target, private val headers: Headers = EmptyHeaders()) : WebApi(target) {
    override fun setupConnection(connection: HttpURLConnection?) {
        headers.values().entries.forEach {
            connection!!.addRequestProperty(it.key, it.value)
        }
    }
}