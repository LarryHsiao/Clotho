package com.silverhetch.clotho.file

import com.silverhetch.clotho.Action
import java.io.File
import java.io.IOException

/**
 * Action to delete given file.
 */
class FileDelete(private val file: File) : Action {
    override fun fire() {
        delete(file)
    }

    private fun delete(file: File) {
        val childFiles = file.listFiles() ?: arrayOf()
        for (childFile in childFiles) {
            if (childFile.isDirectory) {
                delete(childFile)
            } else {
                if (!childFile.delete()) {
                    throw IOException("Can not delete file: ${childFile.absolutePath}")
                }
            }
        }
        if (!file.delete()) {
            throw IOException("Can not delete file: ${file.delete()}")
        }
    }
}