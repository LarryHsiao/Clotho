package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import com.silverhetch.clotho.io.ProgressedCopy
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.print.attribute.standard.Copies

/**
 * Copy [File] source to target [File].
 */
class FileCopy(
    private val src: File,
    private val dst: File,
    private val progress: (copied: Int) -> Unit
) : Source<Unit> {
    override fun value() {
        ProgressedCopy(
            FileInputStream(src),
            FileOutputStream(dst)
        ) { progress(it) }.value()
    }
}