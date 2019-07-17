package com.silverhetch.clotho.media

import com.silverhetch.clotho.file.FileBytes
import com.silverhetch.clotho.file.TextFile
import org.junit.Test

import org.junit.Assert.*
import java.io.File

/**
 * Test for com.silverhetch.clotho.media.PcmToWav
 */
class PcmToWavTest {
    /**
     * Test with simple data, and check the file size.
     */
    @Test
    fun simple() {
        val data = "sample"
        val raw = File.createTempFile("prefix", "").also {
            TextFile(
                it,
                data
            ).value()
        }
        val target = File.createTempFile("prefix", "")

        PcmToWav(
            raw,
            target
        ).fire()

        assertEquals(
            44 + data.toByteArray().size, // wav header size 44 + data size
            FileBytes(target).value().size
        )
    }
}