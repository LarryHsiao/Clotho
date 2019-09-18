package com.silverhetch.clotho.file

import com.silverhetch.clotho.Action
import java.io.File

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
                childFile.delete()
            }
        }
        file.delete()
    }
}