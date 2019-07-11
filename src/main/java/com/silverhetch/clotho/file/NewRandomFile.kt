package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.io.File
import java.util.*

/**
 * Source to generate a File with random name.
 */
class NewRandomFile(
    private val root: File,
    private val name: String = UUID.randomUUID().toString().substring(0, 7)
) : Source<File> {
    override fun value(): File {
        return File(
            root,
            name
        ).also {
            it.parentFile.mkdirs()
            it.createNewFile()
        }
    }
}