package com.larryhsiao.clotho.io

import com.larryhsiao.clotho.Source
import java.io.InputStream
import java.io.OutputStream

/**
 * Copy input stream to output stream.
 */
class ProgressedCopy(
    private val input: InputStream,
    private val output: OutputStream,
    private val bufferSize: Int,
    private val progress: (copied: Int) -> Unit
) : Source<Unit> {
    override fun value() {
        val buffer = ByteArray(bufferSize)
        var readed = input.read(buffer)
        var totalLength = 0
        while (readed != -1) {
            output.write(buffer, 0, readed)
            totalLength += readed
            progress(totalLength)
            readed = input.read(buffer)
        }
        input.close()
        output.close()
    }
}
