package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.io.File
import java.lang.StringBuilder
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
                result.appendln()
            }
            result.append(it)
        }
        return result.toString()
    }
}