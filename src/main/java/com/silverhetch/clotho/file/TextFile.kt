package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.io.File
import java.io.FileWriter

/**
 * Source to generate a text file and initial text in it.
 */
class TextFile(
    private val file: File,
    private val text: String
) : Source<File> {
    override fun value(): File {
        FileWriter(file).use {
            it.write(text)
        }
        return file
    }
}