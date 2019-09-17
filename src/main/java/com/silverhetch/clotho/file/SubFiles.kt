package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.io.File
import java.lang.IllegalArgumentException

/**
 * Source to generate files of given root.
 */
class SubFiles(private val root: File) : Source<List<File>> {
    override fun value(): List<File> {
        return if (root.isDirectory) {
            root.listFiles()?.toList() ?: listOf()
        } else {
            throw IllegalArgumentException("the given file is not a directory")
        }
    }
}