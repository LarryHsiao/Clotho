package com.silverhetch.clotho

/**
 * Wrapper object for Source
 */
open class SourceWrapper<T>(private val source: Source<T>) : Source<T> {
    override fun value(): T {
        return source.value()
    }
}