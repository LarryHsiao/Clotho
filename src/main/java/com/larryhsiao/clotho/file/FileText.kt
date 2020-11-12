package com.larryhsiao.clotho.file

import com.larryhsiao.clotho.Source
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files

/**
 * Source to generate String from file.
 */
class FileText(private val file: File) : Source<String> {
    override fun value(): String {
        val result = StringBuilder()
        Files.lines(file.toPath(), Charset.forName("utf-8")).forEach {
            if (result.isNotEmpty()) { // have lines before
                result.appendLine()
            }
            result.append(it)
        }
        return result.toString()
    }
}