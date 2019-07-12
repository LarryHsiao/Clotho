package com.silverhetch.clotho.io

import com.silverhetch.clotho.Source
import java.io.InputStream
import java.io.OutputStream

/**
 * Copy input stream to output stream.
 *
 * @todo #performance Improve performance.
 */
class ProgressedCopy(
    private val input: InputStream,
    private val output: OutputStream,
    private val progress: (copied: Int) -> Unit
) : Source<Unit> {
    override fun value() {
        var readed = input.read()
        var totalLength = 0
        while (readed != -1) {
            output.write(readed)
            totalLength += 1
            progress(totalLength)
            readed = input.read()
        }
        input.close()
        output.close()
    }
}

