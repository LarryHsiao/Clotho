package com.silverhetch.clotho.io

import com.silverhetch.clotho.Source
import java.io.InputStream
import java.io.OutputStream

/**
 * Copy input stream to output stream.
 */
class ProgressedCopy(
    private val input: InputStream,
    private val output: OutputStream,
    private val progress: (copied: Long) -> Unit
) : Source<Unit> {
    override fun value() {
        val buf = ByteArray(8096)
        var totalLength = 0L
        var readLength = input.read(buf)
        while (readLength != -1) {
            output.write(buf, 0, readLength)
            totalLength += readLength
            progress(totalLength)
            readLength = input.read()
        }
        input.close()
        output.close()
    }
}

