package com.silverhetch.clotho.encryption

import com.silverhetch.clotho.Source
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.xml.bind.DatatypeConverter

/**
 * Calculate MD5 of [InputStream].
 *
 *  @todo #1 Simplify this class
 */
class MD5(private val input: InputStream) : Source<String> {
    override fun value(): String {
        try {
            val md = MessageDigest.getInstance("MD5")

            try {
                val buffer = ByteArray(1024)
                try {
                    while (true) {
                        val read = input.read(buffer)
                        if (read > 0) {
                            md.update(buffer, 0, read)
                        } else {
                            break
                        }
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                try {
                    input.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                return HexString(md.digest()).value()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }
}