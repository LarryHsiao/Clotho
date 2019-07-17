package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.io.DataInputStream
import java.io.File
import java.io.FileInputStream

/**
 * Source to generate Full file`s data with [ByteArray].
 *
 * Note:This class would load entire file into memory, for small file only.
 */
class FileBytes(private val file: File) : Source<ByteArray> {
    override fun value(): ByteArray {
        val bytes = ByteArray(file.length().toInt())
        var input: DataInputStream? = null
        try {
            input = DataInputStream(FileInputStream(file))
            input.read(bytes)
        } finally {
            input?.close()
        }
        return bytes
    }
}