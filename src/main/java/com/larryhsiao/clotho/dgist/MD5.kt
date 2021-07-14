package com.larryhsiao.clotho.dgist

import com.larryhsiao.clotho.Source
import java.io.IOException
import java.io.InputStream
import java.security.MessageDigest

/**
 * Calculate MD5 of [InputStream].
 *
 */
class MD5(private val input: InputStream) : Source<String> {
    override fun value(): String {
        try {
            val md = MessageDigest.getInstance("MD5")

            val buffer = ByteArray(1024)
            var read = input.read(buffer)
            while (read > 0) {
                md.update(buffer, 0, read)
                read = input.read(buffer)
            }
            input.close()
            return HexString(md.digest()).value()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}