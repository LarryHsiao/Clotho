package com.silverhetch.clotho.stream

import com.silverhetch.clotho.Source
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets.UTF_8

/**
 * Source to build [String] from given [InputStream]
 */
class StreamString(private val stream: InputStream) : Source<String> {
    override fun value(): String {
        val result = ByteArrayOutputStream()
        val buffer = ByteArray(4096)
        var length: Int
        while (stream.read(buffer).also { length = it } != -1) {
            result.write(buffer, 0, length)
        }
        return result.toString(UTF_8.name())
    }
}