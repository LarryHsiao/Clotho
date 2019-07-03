package com.silverhetch.clotho.file

import com.silverhetch.clotho.Source
import java.nio.file.Files
import java.nio.file.Path

/**
 * Calculate the size of given file or directory.
 */
class FileSize(private val file: Path) : Source<Long> {
    override fun value(): Long {
        return Files.walk(file)
            .filter { it.toFile().isFile }
            .mapToLong { it.toFile().length() }
            .sum()
    }
}