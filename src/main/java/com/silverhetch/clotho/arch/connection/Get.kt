package com.silverhetch.elizabeth.arch.connection

import com.silverhetch.clotho.connection.Get
import com.silverhetch.clotho.connection.Target
import java.net.HttpURLConnection

/**
 * Http Get with Headers.
 */
class Get(target: Target, private val headers: Headers = EmptyHeaders()) : Get(target) {
    override fun setupConnection(connection: HttpURLConnection?) {
        super.setupConnection(connection)
        headers.values().entries.forEach {
            connection!!.addRequestProperty(it.key, it.value)
        }
    }
}