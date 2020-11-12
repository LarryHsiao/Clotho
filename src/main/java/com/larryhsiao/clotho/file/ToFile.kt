package com.larryhsiao.clotho.file

import com.larryhsiao.clotho.Action
import com.larryhsiao.clotho.io.ProgressedCopy
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream

/**
 * Copy source to target [File].
 */
class ToFile(
    private val input: InputStream,
    private val dst: File,
    private val progress: (copied: Int) -> Unit
) : Action {

    /**
     * File to destination file
     */
    constructor(
        src: File,
        dst: File,
        progress: (copied: Int) -> Unit
    ) : this(
        FileInputStream(src),
        dst,
        progress
    )

    override fun fire() {
        ProgressedCopy(
            input,
            FileOutputStream(dst)
        ) { progress(it) }.value()
    }
}