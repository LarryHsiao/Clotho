package com.larryhsiao.clotho.media

import com.larryhsiao.clotho.file.FileBytes
import com.larryhsiao.clotho.file.TextFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

/**
 * Test for com.larryhsiao.clotho.media.PcmToWav
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