package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.io.File
import java.lang.StringBuilder
import java.nio.file.Files

/**
 * Source to generate String from file.
 */
class FileText(private val file: File) : Source<String> {
    override fun value(): String {
        val result = StringBuilder()
        Files.lines(file.toPath()).forEach {
            if (result.isNotEmpty()) { // have lines before
                result.appendln()
            }
            result.append(it)
        }
        return result.toString()
    }
}